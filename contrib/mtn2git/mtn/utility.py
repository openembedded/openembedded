
import popen2
import select
import fcntl
import os

def set_nonblocking(fd):
    fl = fcntl.fcntl(fd, fcntl.F_GETFL)
    fcntl.fcntl(fd, fcntl.F_SETFL, fl | os.O_NDELAY)

def run_command(command, timeout=None, to_child=None):
    "returns a tuple of (was_timeout, exit_code, data_read)"
    p = popen2.Popen3(command, capturestderr=True)
    set_nonblocking(p.fromchild)
    set_nonblocking(p.childerr)
    fromchild_read = ""
    childerr_read = ""
    was_timeout = False
    if to_child != None:
        p.tochild.write(to_child)
    p.tochild.close()
    while 1:
        ro, rw, re = select.select([p.fromchild], [], [p.childerr], timeout)
        if not ro and not rw and not re:
            was_timeout = True
            break
        if p.fromchild in ro:
            recv = p.fromchild.read()
            if recv == "": break
            fromchild_read += recv
        if p.childerr in re:
            recv = p.childerr.read()
            if recv == "": break
            childerr_read += recv
    if not was_timeout:
        # check for any data we might have missed (due to a premature break)
        # (if there isn't anything we just get a IOError, which we don't mind
        try: fromchild_read += p.fromchild.read()
        except IOError: pass
        try: childerr_read += p.childerr.read()
        except IOError: pass
    p.fromchild.close()
    # if there wasn't a timeout, the program should have exited; in which case we should wait() for it
    # otherwise, it might be hung, so the parent should wait for it.
    # (wrap in a try: except: just in case some other thread happens to wait() and grab ours; god wrapping 
    # python around UNIX is horrible sometimes)
    exitcode = None
    try: 
        if not was_timeout: exitcode = p.wait() >> 8
    except: pass
    return { 'run_command' : command,
         'timeout' : was_timeout, 
         'exitcode' : exitcode, 
         'fromchild' : fromchild_read, 
         'childerr' : childerr_read }

def iter_command(command, timeout=None):
    p = popen2.Popen3(command, capturestderr=True)
    set_nonblocking(p.fromchild)
    set_nonblocking(p.childerr)
    fromchild_read = ""
    childerr_read = ""
    was_timeout = False
    while 1:
        ro, rw, re = select.select([p.fromchild], [], [p.childerr], timeout)
        if not ro and not rw and not re:
            was_timeout = True
            break
        if p.fromchild in ro:
            recv = p.fromchild.read()
            if recv == "": break
            fromchild_read += recv
            while 1:
                nl = fromchild_read.find('\n')
                if nl == -1: break
                yield fromchild_read[:nl]
                fromchild_read = fromchild_read[nl+1:]
        if p.childerr in re:
            recv = p.childerr.read()
            if recv == "": break
            childerr_read += recv
    if not was_timeout:
        # check for any data we might have missed (due to a premature break)
        # (if there isn't anything we just get a IOError, which we don't mind
        try: fromchild_read += p.fromchild.read()
        except IOError: pass
        try: childerr_read += p.childerr.read()
        except IOError: pass
    p.fromchild.close()
    p.tochild.close()
    # yield anything left over
    to_yield = fromchild_read.split('\n')
    while len(to_yield): yield to_yield.pop()
    # call wait()
    try:
        if not was_timeout: p.wait()
    except: pass
    if len(childerr_read): raise Exception("data on stderr (command is %s)" % command, childerr_read)
    if was_timeout: raise Exception("command timeout")

