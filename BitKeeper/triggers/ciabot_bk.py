#!/usr/bin/env python
# ex:ts=4:sw=4:sts=4:et
# -*- tab-width: 4; c-basic-offset: 4; indent-tabs-mode: nil -*-
#
# CIA bot client script for Bitkeeper repositories, written in python.
# This generates commit messages using CIA's XML commit format, and can
# deliver them using either XML-RPC or email.
#
# -- Micah Dowty <micah@navi.cx>
#
# This script is cleaner, more featureful, and faster than the shell
# script version, but won't work on systems without Python or that don't
# allow outgoing HTTP connections.
#
# To use the CIA bot in your Bitkeeper repository...
#
# 1. Customize the parameters below
#
# 2. This script should be called from your repository's post-commit
#    hook with the repository and revision as arguments. For example,
#    you could copy this script into your repository's "hooks" directory
#    and add something like the following to the "post-commit" script,
#    also in the repository's "hooks" directory:
#
#      REPOS="$1"
#      REV="$2"
#      $REPOS/hooks/ciabot_bk.py "$REPOS" "$REV" &
#
#    Or, if you have multiple project hosted, you can add each
#    project's name to the commandline in that project's post-commit
#    hook:
#
#      $REPOS/hooks/ciabot_bk.py "$REPOS" "$REV" "My Project" &
#
############# There are some parameters for this script that you can customize:

class config:
    # Replace this with your project's name, or always provide a
    # project name on the commandline.
    project = "openembedded"

    # If your repository is accessable over the web, put its base URL here
    # and 'uri' attributes will be given to all <file> elements. This means
    # that in CIA's online message viewer, each file in the tree will link
    # directly to the file in your repository
    repositoryURI = None

    # This can be the http:// URI of the CIA server to deliver commits over
    # XML-RPC, or it can be an email address to deliver using SMTP. The
    # default here should work for most people. If you need to use e-mail
    # instead, you can replace this with "cia@cia.navi.cx"
    server = "http://cia.navi.cx"

    # The SMTP server to use, only used if the CIA server above is an
    # email address
    smtpServer = "localhost"

    # The 'from' address to use. If you're delivering commits via email, set
    # this to the address you would normally send email from on this host.
    fromAddress = "cia-user@localhost"

    # When nonzero, print the message to stdout instead of delivering it to CIA
    debug = 0


############# Normally the rest of this won't need modification

import sys, os, re, urllib, xmlrpclib

class UrllibTransport(xmlrpclib.Transport):
    '''Handles an HTTP transaction to an XML-RPC server via urllib
    (urllib includes proxy-server support)
    jjk  07/02/99'''

    def __init__(self):
        self.verbose = 0

    def request(self, host, handler, request_body, verbose=0):
        '''issue XML-RPC request
        jjk  07/02/99'''
        import urllib
        urlopener = urllib.FancyURLopener()
        urlopener.addheaders = [('User-agent', self.user_agent)]
        # probably should use appropriate 'join' methods instead of 'http://'+host+handler
        f = urlopener.open('http://'+host+handler, request_body)
        return(self.parse_response(f))

class File:
    """A file in a Bitkeeper repository. According to our current
    configuration, this may have a module, branch, and URI in addition
    to a path."""

    def __init__(self, fullPath):
        self.fullPath = fullPath
        self.path = fullPath

    def getURI(self, repo):
        """Get the URI of this file, given the repository's URI. This
        encodes the full path and joins it to the given URI."""
        quotedPath = urllib.quote(self.fullPath)
        if quotedPath[0] == '/':
            quotedPath = quotedPath[1:]
        if repo[-1] != '/':
            repo = repo + '/'
        return repo + quotedPath

    def makeTag(self, config):
        """Return an XML tag for this file, using the given config"""
        attrs = {}

        if config.repositoryURI is not None:
            attrs['uri'] = self.getURI(config.repositoryURI)

        attrString = ''.join([' %s="%s"' % (key, escapeToXml(value,1))
                              for key, value in attrs.iteritems()])
        return "<file%s>%s</file>" % (attrString, escapeToXml(self.path))


class CIAClient:
    """Base CIA client class"""
    name = 'Python client for CIA'
    version = '1.0'

    def __init__(self, repository, revision, config):
        self.repository = repository
        self.revision = revision
        self.config = config

    def deliver(self, message):
        if config.debug:
            print message
        else:
            server = self.config.server
            if server.startswith('http:') or server.startswith('https:'):
                # Deliver over XML-RPC
                proxy = os.environ.get('http_proxy')
                if proxy:
                    os.environ['HTTP_PROXY'] = proxy
                    s = xmlrpclib.ServerProxy(server, UrllibTransport())
                else:
                    s = xmlrpclib.ServerProxy(server)
                s.hub.deliver(message)
            else:
                # Deliver over email
                import smtplib
                smtp = smtplib.SMTP(self.config.smtpServer)
                smtp.sendmail(self.config.fromAddress, server,
                              "From: %s\r\nTo: %s\r\n"
                              "Subject: DeliverXML\r\n\r\n%s" %
                              (self.config.fromAddress, server, message))

    def main(self):
        self.collectData()
        import socket
        try:
            self.deliver("<message>" +
                         self.makeGeneratorTag() +
                         self.makeSourceTag() +
                         self.makeBodyTag() +
                         "</message>")
            return 0
        except socket.error, e:
            print "ERROR: socket: %s" % e
            return 1

    def makeAttrTags(self, *names):
        """Given zero or more attribute names, generate XML elements for
           those attributes only if they exist and are non-None.
           """
        s = ''
        for name in names:
            if hasattr(self, name):
                v = getattr(self, name)
                if v is not None:
                    s += "<%s>%s</%s>" % (name, escapeToXml(str(v)), name)
        return s

    def makeGeneratorTag(self):
        return "<generator>%s</generator>" % self.makeAttrTags(
            'name',
            'version',
            )

    def makeSourceTag(self):
        self.project = self.config.project
        return "<source>%s</source>" % self.makeAttrTags(
            'project',
            'module',
            'branch',
            )

    def makeBodyTag(self):
        return "<body><commit>%s%s</commit></body>" % (
            self.makeAttrTags(
            'revision',
            'author',
            'log',
            'diffLines',
            ),
            self.makeFileTags(),
            )

    def makeFileTags(self):
        """Return XML tags for our file list"""
        return "<files>%s</files>" % ''.join([file.makeTag(self.config)
                                              for file in self.files])

    def collectData(self):
        raise NotImplementedError("collectData method not implemented in the base CIA client class.")

def escapeToXml(text, isAttrib=0):
    text = text.replace("&", "&amp;")
    text = text.replace("<", "&lt;")
    text = text.replace(">", "&gt;")
    if isAttrib == 1:
        text = text.replace("'", "&apos;")
        text = text.replace("\"", "&quot;")
    return text

class BKClient(CIAClient):
    """A CIA client for Bitkeeper repositories."""
    name = 'Python Bitkeeper client for CIA'
    version = '1.0'

    def __init__(self, repository, revision, config):
        CIAClient.__init__(self, repository, revision, config)
        os.chdir(self.repository)

    def bkchanges(self, command):
        """Run the given bkchanges command on our current repository and
        revision, returning all output"""
        return os.popen('bk changes %s -r"%s"' % \
                        (command, self.revision)).read()

    def collectData(self):
        self.author = self.bkchanges('-d\':P:\'').strip()
        self.log = self.bkchanges('-d\'$if(:C:){$each(:C:){:C: \\\\n}}\'').strip()
        self.diffLines = len(os.popen('bk export -tpatch -r"%s"|grep -v \'^#\'' % self.revision).read().split('\n'))
        self.files = self.collectFiles()
        self.module = os.path.basename(os.environ.get('BKD_ROOT') or '')
        self.branch = self.bkchanges('-d\':TAG:\'')

    def collectFiles(self):
        # Extract all the files from the output of 'bkchanges changed'
        files = []
        for line in self.bkchanges('-n -v -d\'$unless(:GFILE:=ChangeSet){:GFILE:}\'').strip().split('\n'):
            files.append(File(line))
        return files


if __name__ == "__main__":
    # Print a usage message when not enough parameters are provided.
    if len(sys.argv) < 3:
        sys.stderr.write("USAGE: %s REPOS-PATH REVISION [PROJECTNAME]\n" %
                         sys.argv[0])
        sys.exit(1)

    # If a project name was provided, override the default project name.
    if len(sys.argv) > 3:
        config.project = sys.argv[3]

    # Go do the real work.
    BKClient(sys.argv[1], sys.argv[2], config).main()
