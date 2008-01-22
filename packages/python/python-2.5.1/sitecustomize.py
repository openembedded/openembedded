# OpenEmbedded sitecustomize.py (C) 2002-2008 Michael 'Mickey' Lauer <mlauer@vanille-media.de>
# GPLv2 or later
# Version: 20082201
# Features:
# * set proper default encoding
# * enable readline completion in the interactive interpreter
# * load command line history on startup
# * save command line history on exit 

HISTORY_FILENAME = "/tmp/python-history-file.txt"

def __exithandler():
    try:
        readline.write_history_file( HISTORY_FILENAME )
    except IOError:
        pass

def __registerExitHandler():
    import atexit
    atexit.register( __exithandler )

def __enableReadlineSupport():
    readline.parse_and_bind("tab: complete")
    try:
        readline.read_history_file( "/tmp/python-history-file.txt" )
    except IOError:
        pass

def __enableDefaultEncoding():
    import sys
    try:
        sys.setdefaultencoding('utf8')
    except LookupError:
        pass

import sys
try:
    import rlcompleter, readline
except ImportError:
    sys.stderr.write( "Python %s (OpenEmbedded build) sitecustomize.py not active. Please install python-readline.\n" % sys.version.split()[0] )
else:
    __enableDefaultEncoding()
    __registerExitHandler()
    __enableReadlineSupport()
    sys.stderr.write( "Python %s (OpenEmbedded build) sitecustomize.py active.\n" % sys.version.split()[0] )
