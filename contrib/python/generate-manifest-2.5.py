#!/usr/bin/env python

# generate Python Manifest for the OpenEmbedded build system
# (C) 2002-2008 Michael 'Mickey' Lauer <mlauer@vanille-media.de>
# (C) 2007 Jeremy Laine
# licensed under MIT, see COPYING.MIT

import os
import sys
import time

VERSION = "2.5.2"
BASEREV = 0

__author__ = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
__version__ = "20081209"

class MakefileMaker:

    def __init__( self, outfile ):
        """initialize"""
        self.packages = {}
        self.targetPrefix = "${libdir}/python%s/" % VERSION[:3]
        self.output = outfile
        self.out( """
# WARNING: This file is AUTO GENERATED: Manual edits will be lost next time I regenerate the file.
# Generator: '%s' Version %s (C) 2002-2008 Michael 'Mickey' Lauer <mlauer@vanille-media.de>
# Visit the Python for Embedded Systems Site => http://www.Vanille.de/projects/python.spy
""" % ( sys.argv[0], __version__ ) )

    #
    # helper functions
    #

    def out( self, data ):
        """print a line to the output file"""
        self.output.write( "%s\n" % data )

    def setPrefix( self, targetPrefix ):
        """set a file prefix for addPackage files"""
        self.targetPrefix = targetPrefix

    def doProlog( self ):
        self.out( """ """ )
        self.out( "" )

    def addPackage( self, revision, name, description, dependencies, filenames ):
        """add a package to the Makefile"""
        if type( filenames ) == type( "" ):
            filenames = filenames.split()
        fullFilenames = []
        for filename in filenames:
            if filename[0] != "$":
                fullFilenames.append( "%s%s" % ( self.targetPrefix, filename ) )
            else:
                fullFilenames.append( filename )
        self.packages[name] = revision, description, dependencies, fullFilenames

    def doBody( self ):
        """generate body of Makefile"""

        global VERSION

        #
        # generate provides line
        # 
 
        provideLine = 'PROVIDES+="'
        for name in self.packages:
            provideLine += "%s " % name
        provideLine += '"'

        self.out( provideLine )
        self.out( "" )       

        #
        # generate package line
        #

        packageLine = 'PACKAGES="'
        for name in self.packages:
            packageLine += "%s " % name
        packageLine += ' python-modules"'

        self.out( packageLine )
        self.out( "" )

        #
        # generate package variables
        #

        for name, data in self.packages.iteritems():
            rev, desc, deps, files = data

            #
            # write out the description, revision and dependencies
            #
            self.out( 'DESCRIPTION_%s="%s"' % ( name, desc ) )
            self.out( 'PR_%s="ml%d"' % ( name, rev + BASEREV ) )
            self.out( 'RDEPENDS_%s="%s"' % ( name, deps ) )

            line = 'FILES_%s="' % name

            #
            # check which directories to make in the temporary directory
            #

            dirset = {} # if python had a set-datatype this would be sufficient. for now, we're using a dict instead.
            for target in files:
                dirset[os.path.dirname( target )] = True

            #
            # generate which files to copy for the target (-dfR because whole directories are also allowed)
            #

            for target in files:
                line += "%s " % target

            line += '"'
            self.out( line )
            self.out( "" )

        self.out( 'DESCRIPTION_python-modules="All Python modules"' )
        line = 'RDEPENDS_python-modules="'

        for name, data in self.packages.iteritems():
            if name != 'python-core-dbg':
                line += "%s " % name

        self.out( "%s \"" % line )
        self.out( 'ALLOW_EMPTY_python-modules = "1"' )

    def doEpilog( self ):
        self.out( """""" )
        self.out( "" )

    def make( self ):
        self.doProlog()
        self.doBody()
        self.doEpilog()

if __name__ == "__main__":

    if len( sys.argv ) > 1:
        os.popen( "rm -f ./%s" % sys.argv[1] )
        outfile = file( sys.argv[1], "w" )
    else:
        outfile = sys.stdout

    m = MakefileMaker( outfile )

    # Add packages here. Only specify dlopen-style library dependencies here, no ldd-style dependencies!
    # Parameters: revision, name, description, dependencies, filenames
    #

    m.addPackage( 0, "python-core", "Python Interpreter and core modules (needed!)", "",
    "__future__.* copy.* copy_reg.* ConfigParser.* " +
    "getopt.* linecache.* new.* " +
    "os.* posixpath.* struct.* " +
    "warnings.* site.* stat.* " +
    "UserDict.* UserList.* UserString.* " +
    "lib-dynload/binascii.so lib-dynload/_struct.so lib-dynload/time.so " +
    "lib-dynload/xreadlines.so types.* ${bindir}/python*" )

    m.addPackage( 0, "python-core-dbg", "Python core module debug information", "python-core",
    "lib-dynload/.debug ${bindir}/.debug ${libdir}/.debug" )

    m.addPackage( 0, "python-devel", "Python Development Package", "python-core",
    "${includedir} config" ) # package

    m.addPackage( 0, "python-idle", "Python Integrated Development Environment", "python-core python-tkinter",
    "${bindir}/idle idlelib" ) # package

    m.addPackage( 0, "python-pydoc", "Python Interactive Help Support", "python-core python-lang python-stringold python-re",
    "${bindir}/pydoc pydoc.*" )

    m.addPackage( 0, "python-smtpd", "Python Simple Mail Transport Daemon", "python-core python-netserver python-email python-mime",
    "${bindir}/smtpd.*" )

    m.addPackage( 0, "python-audio", "Python Audio Handling", "python-core",
    "wave.* chunk.* sndhdr.* lib-dynload/ossaudiodev.so lib-dynload/audioop.so" )

    m.addPackage( 0, "python-bsddb", "Python Berkeley Database Bindings", "python-core",
    "bsddb lib-dynload/_bsddb.so" ) # package

    m.addPackage( 0, "python-codecs", "Python Codecs, Encodings & i18n Support", "python-core python-lang",
    "codecs.* encodings gettext.* locale.* lib-dynload/_locale.so lib-dynload/unicodedata.so stringprep.* xdrlib.*" )

    m.addPackage( 0, "python-compile", "Python Bytecode Compilation Support", "python-core",
    "py_compile.* compileall.*" )

    m.addPackage( 0, "python-compiler", "Python Compiler Support", "python-core",
    "compiler" ) # package

    m.addPackage( 0, "python-compression", "Python High Level Compression Support", "python-core python-zlib",
    "gzip.* zipfile.* tarfile.*" )

    m.addPackage( 0, "python-crypt", "Python Basic Cryptographic and Hashing Support", "python-core",
    "hashlib.* md5.* sha.* lib-dynload/crypt.so lib-dynload/_hashlib.so lib-dynload/_sha256.so lib-dynload/_sha512.so" )

    m.addPackage( 0, "python-textutils", "Python Option Parsing, Text Wrapping and Comma-Separated-Value Support", "python-core python-io python-re python-stringold",
    "lib-dynload/_csv.so csv.* optparse.* textwrap.*" )

    m.addPackage( 0, "python-curses", "Python Curses Support", "python-core",
    "curses lib-dynload/_curses.so lib-dynload/_curses_panel.so" ) # directory + low level module

    m.addPackage( 0, "python-ctypes", "Python C Types Support", "python-core",
    "ctypes lib-dynload/_ctypes.so" ) # directory + low level module

    m.addPackage( 0, "python-datetime", "Python Calendar and Time support", "python-core python-codecs",
    "_strptime.* calendar.* lib-dynload/datetime.so" )

    m.addPackage( 0, "python-db", "Python File-Based Database Support", "python-core",
    "anydbm.* dumbdbm.* whichdb.* " )

    m.addPackage( 0, "python-debugger", "Python Debugger", "python-core python-io python-lang python-re python-stringold python-shell python-pprint",
    "bdb.* pdb.*" )

    m.addPackage( 0, "python-difflib", "Python helpers for computing deltas between objects.", "python-lang python-re",
    "difflib.*" )

    m.addPackage( 0, "python-distutils", "Python Distribution Utilities", "python-core",
    "config distutils" ) # package

    m.addPackage( 0, "python-doctest", "Python framework for running examples in docstrings.", "python-core python-lang python-io python-re python-unittest python-debugger python-difflib",
    "doctest.*" )

    m.addPackage( 0, "python-email", "Python Email Support", "python-core python-io python-re python-mime python-audio python-image",
    "email" ) # package

    m.addPackage( 0, "python-fcntl", "Python's fcntl Interface", "python-core",
    "lib-dynload/fcntl.so" )

    m.addPackage( 0, "python-hotshot", "Python Hotshot Profiler", "python-core",
    "hotshot lib-dynload/_hotshot.so" )

    m.addPackage( 0, "python-html", "Python HTML Processing", "python-core",
    "formatter.* htmlentitydefs.* htmllib.* markupbase.* sgmllib.* " )

    m.addPackage( 0, "python-gdbm", "Python GNU Database Support", "python-core",
    "lib-dynload/gdbm.so" )

    m.addPackage( 0, "python-image", "Python Graphical Image Handling", "python-core",
    "colorsys.* imghdr.* lib-dynload/imageop.so lib-dynload/rgbimg.so" )

    m.addPackage( 0, "python-io", "Python Low-Level I/O", "python-core python-math",
    "lib-dynload/_socket.so lib-dynload/_ssl.so lib-dynload/select.so lib-dynload/termios.so lib-dynload/cStringIO.so "
    "pipes.* socket.* tempfile.* StringIO.* " )

    m.addPackage( 0, "python-lang", "Python Low-Level Language Support", "python-core",
    "lib-dynload/array.so lib-dynload/parser.so lib-dynload/operator.so lib-dynload/_weakref.so " +
    "lib-dynload/itertools.so lib-dynload/collections.so lib-dynload/_bisect.so lib-dynload/_heapq.so " +
    "atexit.* bisect.* code.* codeop.* dis.* heapq.* inspect.* keyword.* opcode.* symbol.* repr.* token.* " +
    " tokenize.* traceback.* linecache.* weakref.*" )

    m.addPackage( 0, "python-logging", "Python Logging Support", "python-core python-io python-lang python-pickle python-stringold",
    "logging" ) # package

    m.addPackage( 0, "python-tkinter", "Python Tcl/Tk Bindings", "python-core",
    "lib-dynload/_tkinter.so lib-tk" ) # package

    m.addPackage( 0, "python-math", "Python Math Support", "python-core",
    "lib-dynload/cmath.so lib-dynload/math.so lib-dynload/_random.so random.* sets.*" )

    m.addPackage( 0, "python-mime", "Python MIME Handling APIs", "python-core python-io",
    "mimetools.* uu.* quopri.* rfc822.*" )

    m.addPackage( 0, "python-mmap", "Python Memory-Mapped-File Support", "python-core python-io",
    "lib-dynload/mmap.so " )

    m.addPackage( 0, "python-unixadmin", "Python Unix Administration Support", "python-core",
    "lib-dynload/nis.so lib-dynload/grp.so lib-dynload/pwd.so getpass.*" )

    m.addPackage( 0, "python-netclient", "Python Internet Protocol Clients", "python-core python-crypt python-datetime python-io python-lang python-logging python-mime",
    "*Cookie*.* " + 
    "base64.* cookielib.* ftplib.* gopherlib.* hmac.* httplib.* mimetypes.* nntplib.* poplib.* smtplib.* telnetlib.* urllib.* urllib2.* urlparse.* uuid.*" )

    m.addPackage( 0, "python-netserver", "Python Internet Protocol Servers", "python-core python-netclient",
    "cgi.* BaseHTTPServer.* SimpleHTTPServer.* SocketServer.*" )

    m.addPackage( 0, "python-pickle", "Python Persistence Support", "python-core python-codecs python-io python-re",
    "pickle.* shelve.* lib-dynload/cPickle.so" )

    m.addPackage( 0, "python-pkgutil", "Python Package Extension Utility Support", "python-core",
    "pkgutil.*")

    m.addPackage( 0, "python-pprint", "Python Pretty-Print Support", "python-core",
    "pprint.*" )

    m.addPackage( 0, "python-profile", "Python Basic Profiling Support", "python-core python-textutils",
    "profile.* pstats.* cProfile.* lib-dynload/_lsprof.so" )

    m.addPackage( 0, "python-re", "Python Regular Expression APIs", "python-core",
    "re.* sre.* sre_compile.* sre_constants* sre_parse.*" ) # _sre is builtin

    m.addPackage( 0, "python-readline", "Python Readline Support", "python-core",
    "lib-dynload/readline.so rlcompleter.*" )

    m.addPackage( 0, "python-resource", "Python Resource Control Interface", "python-core",
    "lib-dynload/resource.so" )

    m.addPackage( 0, "python-shell", "Python Shell-Like Functionality", "python-core python-re",
    "cmd.* commands.* dircache.* fnmatch.* glob.* popen2.* shlex.* shutil.*" )

    m.addPackage( 0, "python-robotparser", "Python robots.txt parser", "python-core python-netclient",
    "robotparser.*")

    m.addPackage( 0, "python-subprocess", "Python Subprocess Support", "python-core python-io python-re python-fcntl python-pickle",
    "subprocess.*" )

    m.addPackage( 0, "python-sqlite3", "Python Sqlite3 Database Support", "python-core python-datetime python-lang python-crypt python-io python-threading python-zlib",
    "lib-dynload/_sqlite3.so sqlite3/dbapi2.* sqlite3/__init__.*" )

    m.addPackage( 0, "python-sqlite3-tests", "Python Sqlite3 Database Support Tests", "python-core python-sqlite3",
    "sqlite3/test" )

    m.addPackage( 0, "python-stringold", "Python String APIs [deprecated]", "python-core python-re",
    "lib-dynload/strop.so string.*" )

    m.addPackage( 0, "python-syslog", "Python's Syslog Interface", "python-core",
    "lib-dynload/syslog.so" )

    m.addPackage( 0, "python-terminal", "Python Terminal Controlling Support", "python-core python-io",
    "pty.* tty.*" )

    m.addPackage( 0, "python-tests", "Python Tests", "python-core",
    "test" ) # package

    m.addPackage( 0, "python-threading", "Python Threading & Synchronization Support", "python-core python-lang",
    "_threading_local.* dummy_thread.* dummy_threading.* mutex.* threading.* Queue.*" )

    m.addPackage( 0, "python-unittest", "Python Unit Testing Framework", "python-core python-stringold python-lang",
    "unittest.*" )

    m.addPackage( 0, "python-xml", "Python basic XML support.", "python-core python-re",
    "lib-dynload/pyexpat.so xml xmllib.*" ) # package

    m.addPackage( 0, "python-xmlrpc", "Python XMLRPC Support", "python-core python-xml python-netserver python-lang",
    "xmlrpclib.* SimpleXMLRPCServer.*" )

    m.addPackage( 0, "python-zlib", "Python zlib Support.", "python-core",
    "lib-dynload/zlib.so" )

    m.addPackage( 0, "python-mailbox", "Python Mailbox Format Support", "python-core python-mime",
    "mailbox.*" )

    # FIXME consider adding to python-compression
    m.addPackage( 0, "python-bzip2", "Python bzip2 support", "python-core",
    "lib-dynload/bz2.so" )

    # FIXME consider adding to some higher level package
    m.addPackage( 0, "python-elementtree", "Python elementree", "python-core",
    "lib-dynload/_elementtree.so" )

    m.make()
