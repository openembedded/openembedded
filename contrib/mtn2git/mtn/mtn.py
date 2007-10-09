
import os
import re
import fcntl
import pipes
import select
import threading
import popen2
from common import set_nonblocking, terminate_popen3
from traceback import format_exc
import genproxy
import sys

# regular expressions that are of general use when 
# validating monotone output
def group_compile(r):
    return re.compile('('+r+')')

hex_re = r'[A-Fa-f0-9]*'
hex_re_c = group_compile(hex_re)
revision_re = r'[A-Fa-f0-9]{40}'
revision_re_c = group_compile(revision_re)
name_re = r'^[\S]+'
name_re_c = group_compile(name_re)

class MonotoneException(Exception):
    pass

class Revision(str):
    def __init__(self, v):
        # special case that must be handled: empty (initial) revision ID ''
        str.__init__(v)
        self.obj_type = "revision"
        if v != '' and not revision_re_c.match(self):
            raise MonotoneException("Not a valid revision ID: %s" % (v))
    def abbrev(self):
        return '[' + self[:8] + '..]'

class Author(str):
    def __init__(self, v):
        str.__init__(v)
        self.obj_type = "author"
        
class Runner:
    def __init__(self, monotone, database):
        self.base_command = [monotone, "--db=%s" % pipes.quote(database)]

packet_header_re = re.compile(r'^(\d+):(\d+):([lm]):(\d+):')

class Automate(Runner):
    """Runs commands via a particular monotone process. This 
       process is started the first time run() is called, and 
       stopped when this class instance is deleted or the stop()
       method is called.
       
       If an error occurs, the monotone process may need to be 
       stopped and a new one created.
       """
    def __init__(self, *args, **kwargs):
        Runner.__init__(*[self] + list(args), **kwargs)
        self.lock = threading.Lock()
        self.process = None

    def stop(self):
        if not self.process:
            return
        terminate_popen3(self.process)
        self.process = None
 
    def __process_required(self):
        if self.process != None:
            return
        to_run = self.base_command + ['automate', 'stdio']
        self.process = popen2.Popen3(to_run, capturestderr=True)
        # breaks down with toposort and a lot of input
        #map (set_nonblocking, [ self.process.fromchild,
        #                        self.process.tochild,
        #                        self.process.childerr ])
        map (set_nonblocking, [ self.process.fromchild,
                                self.process.childerr ])

    def run(self, *args, **kwargs):
        print >> sys.stderr, (("automate is running:", args, kwargs))

        lock = self.lock
        stop = self.stop
        class CleanRequest(genproxy.GeneratorProxy):
            def __init__(self, *args, **kwargs):
                genproxy.GeneratorProxy.__init__(self, *args, **kwargs)

                # nb; this used to be False, but True seems to behave more sensibly.
                # in particular, if someone holds down Refresh sometimes the code 
                # gets here before __del__ is called on the previous iterator, 
                # causing a pointless error to occur
                if not lock.acquire(True):
                    # I've checked; this exception does _not_ cause __del__ to run, so 
                    # we don't accidentally unlock a lock below
                    raise MonotoneException("Automate request cannot be called: it is already locked! This indicates a logic error in ViewMTN; please report.")

            def __del__(self):
                def read_any_unread_output():
                    try:
                        # this'll raise StopIteration if we're done
                        self.next()
                        # okay, we're not done..
                        print >> sys.stderr, ("warning: Automate output not completely read; reading manually.")
                        for stanza in self:
                            pass
                    except StopIteration:
                        pass

                try:
                    read_any_unread_output()
                    lock.release()
                except:
                    print >> sys.stderr, ("exception cleaning up after Automation; calling stop()!")
                    stop()

        return CleanRequest(self.__run(*args, **kwargs))

    def __run(self, command, args):
        enc = "l%d:%s" % (len(command), command)
        enc += ''.join(["%d:%s" % (len(x), x) for x in args]) + 'e'

        # number of tries to get a working mtn going..
        for i in xrange(2):
            self.__process_required()
            try:
                self.process.tochild.write(enc)
                self.process.tochild.flush()
                break
            except:
                # mtn has died underneath the automate; restart it
                print >> sys.stderr, ("exception writing to child process; attempting restart: %s" % format_exc())
                self.stop()

        import sys
        def read_result_packets():
            buffer = ""
            while True:
                r_stdin, r_stdout, r_stderr = select.select([self.process.fromchild], [], [], None)
                if not r_stdin and not r_stdout and not r_stderr:
                    break

                if self.process.fromchild in r_stdin:
                    data = self.process.fromchild.read()
                    if data == "":
                        break
                    buffer += data

                # loop, trying to get complete packets out of our buffer
                complete, in_packet = False, False
                while not complete and buffer != '':
                    if not in_packet:
                        m = packet_header_re.match(buffer)
                        if not m:
                            break
                        in_packet = True
                        cmdnum, errnum, pstate, length = m.groups()
                        errnum = int(errnum)
                        length = int(length)
                        header_length = m.end(m.lastindex) + 1 # the '1' is the colon

                    if len(buffer) < length + header_length:
                        # not enough data read from client yet; go round
                        break
                    else:
                        result = buffer[header_length:header_length+length]
                        buffer = buffer[header_length+length:]
                        complete = pstate == 'l'
                        in_packet = False
                        yield errnum, complete, result

                if complete:
                    break
                
        # get our response, and yield() it back one line at a time
        code_max = -1
        data_buf = ''
        for code, is_last, data in read_result_packets():
            if code and code > code_max:
                code_max = code
            data_buf += data
            while True:
                nl_idx = data_buf.find('\n')
                if nl_idx == -1:
                    break
                yield data_buf[:nl_idx+1]
                data_buf = data_buf[nl_idx+1:]
        # left over data?
        if data_buf:
            yield data_buf
        if code_max > 0:
            raise MonotoneException("error code %d in automate packet." % (code_max))

class Standalone(Runner):
    """Runs commands by running monotone. One monotone process 
       per command"""

    def run(self, command, args):
        # as we pass popen3 as sequence, it executes monotone with these 
        # arguments - and does not pass them through the shell according 
        # to help(os.popen3)
#       print(("standalone is running:", command, args))
        to_run = self.base_command + [command] + args
        process = popen2.Popen3(to_run, capturestderr=True)
        for line in process.fromchild:
            yield line
        stderr_data = process.childerr.read()
        if len(stderr_data) > 0:
            raise MonotoneException("data on stderr for command '%s': %s" % (command, 
                                                                             stderr_data))
        terminate_popen3(process)

class MtnObject:
    def __init__(self, obj_type):
        self.obj_type = obj_type

class Tag(MtnObject):
    def __init__(self, name, revision, author, branches):
        MtnObject.__init__(self, "tag")
        self.name, self.revision, self.author, self.branches = name, Revision(revision), author, branches

class Branch(MtnObject):
    def __init__(self, name):
        MtnObject.__init__(self, "branch")
        self.name = name

class File(MtnObject):
    def __init__(self, name, in_revision):
        MtnObject.__init__(self, "file")
        self.name = name
        self.in_revision = in_revision

class Dir(MtnObject):
    def __init__(self, name, in_revision):
        MtnObject.__init__(self, "dir")
        self.name = name
        self.in_revision = in_revision

basic_io_name_tok = re.compile(r'^(\S+)')

def basic_io_from_stream(gen):
    # all of these x_consume functions return parsed string 
    # token to add to stanza, name of next consume function to call
    # new value of line (eg. with consumed tokens removed)

    def hex_consume(line):
        m = hex_re_c.match(line[1:])
        if line[0] != '[' or not m:
            raise MonotoneException("This is not a hex token: %s" % line)
        end_of_match = m.end(m.lastindex)
        if line[end_of_match+1] != ']':
            raise MonotoneException("Hex token ends in character other than ']': %s" % line)
        return Revision(m.groups()[0]), choose_consume, line[end_of_match+2:]

    def name_consume(line):
        m = name_re_c.match(line)
        if not m:
            raise MonotoneException("Not a name: %s" % line)
        end_of_match = m.end(m.lastindex)
        return m.groups()[0], choose_consume, line[end_of_match:]

    def choose_consume(line):
        line = line.lstrip()
        if line == '':
            consumer = choose_consume
        elif line[0] == '[':
            consumer = hex_consume
        elif line[0] == '"':
            consumer = string_consume
        else:
            consumer = name_consume
        return None, consumer, line

    class StringState:
        def __init__(self):
            self.in_escape = False
            self.has_started = False
            self.has_ended = False
            self.value = ''

    def string_consume(line, state=None):
        if not state:
            state = StringState()

        if not state.has_started:
            if line[0] != '"':
                raise MonotoneException("Not a string: %s" % line)
            line = line[1:]
            state.has_started = True

        idx = 0
        for idx, c in enumerate(line):
            if state.in_escape:
                if c != '\\' and c != '"':
                    raise MonotoneException("Invalid escape code: %s in %s\n" % (c, line))
                state.value += c
                state.in_escape = False
            else:
                if c == '\\':
                    state.in_escape = True
                elif c == '"':
                    state.has_ended = True
                    break
                else:
                    state.value += c

        if state.has_ended:
            return state.value, choose_consume, line[idx+1:]
        else:
            return (None, 
                    lambda s: string_consume(s, state), 
                    line[idx+1:])

    consumer = choose_consume
    current_stanza = []
    for line in gen:
        # if we're not in an actual consumer (which we shouldn't be, unless 
        # we're parsing some sort of multi-line token) and we have a blank 
        # line, it indicates the end of any current stanza
        if (consumer == choose_consume) and (line == '' or line == '\n') and current_stanza:
            yield current_stanza
            current_stanza = []
            continue

        while line != '' and line != '\n':
            new_token, consumer, line = consumer(line)
            if new_token != None:
                current_stanza.append(new_token)
    if current_stanza:
        yield current_stanza
        
class Operations:
    def __init__(self, runner_args):
        self.standalone = apply(Standalone, runner_args)
        self.automate = apply(Automate, runner_args)

    def tags(self):
        for stanza in basic_io_from_stream(self.automate.run('tags', [])):
            if stanza[0] == 'tag':
                branches = []
                for branch in stanza[7:]:
                    branches.append(Branch(branch))
                yield Tag(stanza[1], stanza[3], stanza[5], branches)

    def branches(self):
        for line in (t.strip() for t in self.automate.run('branches', [])):
            if not line:
                continue
            yield apply(Branch, (line,))

    def graph(self):
        for line in self.automate.run('graph', []):
            yield line

    def parents(self, revision):
        if revision != "":
            for line in (t.strip() for t in self.automate.run('parents', [revision])):
                if not line:
                    continue
                yield apply(Revision, (line,))

    def ancestry_difference(self, new_rev, old_revs):
	"""
	new_rev a single new revision number
	old_revs a list of revisions
	"""
	if new_rev != "":
	    for line in (t.strip() for t in self.automate.run('ancestry_difference', [new_rev]+old_revs)):
		if not line:
		    continue
		yield apply(Revision, (line,))

    def children(self, revision):
        if revision != "":
            for line in (t.strip() for t in self.automate.run('children', [revision])):
                if not line:
                    continue
                yield apply(Revision, (line,))

    def toposort(self, revisions):
        for line in (t.strip() for t in self.automate.run('toposort', revisions)):
            if not line:
                continue
            yield apply(Revision, (line,))

    def heads(self, branch):
        for line in (t.strip() for t in self.automate.run('heads', [branch])):
            if not line:
                continue
            yield apply(Revision, (line,))

    def get_content_changed(self, revision, path):
        for stanza in basic_io_from_stream(self.automate.run('get_content_changed', [revision, path])):
            yield stanza

    def get_revision(self, revision):
        for stanza in basic_io_from_stream(self.automate.run('get_revision', [revision])):
            yield stanza

    def get_manifest_of(self, revision):
        for stanza in basic_io_from_stream(self.automate.run('get_manifest_of', [revision])):
            yield stanza

    def get_file(self, fileid):
        for stanza in self.automate.run('get_file', [fileid]):
            yield stanza

    def certs(self, revision):
        for stanza in basic_io_from_stream(self.automate.run('certs', [revision])):
            yield stanza

    def diff(self, revision_from, revision_to, files=[]):
        args = ['-r', revision_from, '-r', revision_to] + files
        for line in self.standalone.run('diff', args):
            yield line


