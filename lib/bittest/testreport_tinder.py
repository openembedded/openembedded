# ex:ts=4:sw=4:sts=4:et
# -*- tab-width: 4; c-basic-offset: 4; indent-tabs-mode: nil -*-
#
#
# Copyright (C)       2005, 2006 Holger Hans Peter Freyther
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
#
#   Redistributions of source code must retain the above copyright notice,
#   this list of conditions and the following disclaimer.
#
#   Redistributions in binary form must reproduce the above copyright
#   notice, this list of conditions and the following disclaimer in the
#   documentation and/or other materials provided with the distribution.
#
#   Neither the name Holger Hans Peter Freyther nor the names of its
#   contributors may be used to endorse or promote products derived
#   from this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
# FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
# COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
# (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
# SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
# HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
# STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
# IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
# POSSIBILITY OF SUCH DAMAGE.

__version__ = "0.0"

import os, sys


#
#
# Methods from the tinderclient.bbclass
#
#


def tinder_http_post(server, selector, content_type, body):
    import httplib
    # now post it
    for i in range(0,5):
       try:
           h = httplib.HTTP(server)
           h.putrequest('POST', selector)
           h.putheader('content-type', content_type)
           h.putheader('content-length', str(len(body)))
           h.endheaders()
           h.send(body)
           errcode, errmsg, headers = h.getreply()
           #print errcode, errmsg, headers
           return (errcode,errmsg, headers, h.file)
       except:
           print "Error sending the report!"
           # try again
           pass

    # return some garbage
    return (-1, "unknown", "unknown", None)

def tinder_form_data(bound, dict, log):
    output = []
    # for each key in the dictionary
    for name in dict:
        output.append( "--" + bound )
        output.append( 'Content-Disposition: form-data; name="%s"' % name )
        output.append( "" )
        print "Adding %s %s" % (name, dict[name])
        output.append( dict[name] )

    if log:
        output.append( "--" + bound )
        output.append( 'Content-Disposition: form-data; name="log"; filename="log.txt"' )
        output.append( '' )
        output.append( log )
    output.append( '--' + bound + '--' )
    output.append( '' )

    return "\r\n".join(output)

def tinder_format_http_post(d,status,log, test_name):
    """
    Format the Tinderbox HTTP post with the data needed
    for the tinderbox to be happy.
    """

    from bb import data, build
    import os,random

    # the variables we will need to send on this form post
    variables =  {
        "tree"         : data.getVar('TINDER_TREE',    d, True),
        "machine_name" : "%s-%s" % (data.getVar('TINDER_MACHINE', d, True), test_name),
        "os"           : os.uname()[0],
        "os_version"   : os.uname()[2],
        "compiler"     : "gcc",
        "clobber"      : data.getVar('TINDER_CLOBBER', d, True)
    }

    # optionally add the status
    if status:
        variables["status"] = str(status)

    # try to load the machine id
    # we only need on build_status.pl but sending it
    # always does not hurt
    try:
        f = file(data.getVar('TMPDIR',d,True)+'/tinder-machine.id', 'r')
        id = f.read()
        variables['machine_id'] = id
    except:
        pass

    # the boundary we will need
    boundary = "----------------------------------%d" % int(random.random()*1000000000000)

    # now format the body
    body = tinder_form_data( boundary, variables, log )

    return ("multipart/form-data; boundary=%s" % boundary),body


def tinder_build_start(d, test_name):
    """
    Inform the tinderbox that a build is starting. We do this
    by posting our name and tree to the build_start.pl script
    on the server.
    """
    from bb import data

    # get the body and type
    content_type, body = tinder_format_http_post(d,None,None, test_name)
    server = data.getVar('TINDER_HOST', d, True )
    url    = data.getVar('TINDER_URL',  d, True )

    selector = url + "/xml/build_start.pl"

    #print "selector %s and url %s" % (selector, url)

    # now post it
    errcode, errmsg, headers, h_file = tinder_http_post(server,selector,content_type, body)
    #print errcode, errmsg, headers
    report = h_file.read()

    # now let us find the machine id that was assigned to us
    search = "<machine id='"
    report = report[report.find(search)+len(search):]
    report = report[0:report.find("'")]

    import bb
    bb.note("Machine ID assigned by tinderbox: %s" % report )

    # now we will need to save the machine number
    # we will override any previous numbers
    bb.mkdirhier(data.getVar('TMPDIR', d, True))
    f = file(data.getVar('TMPDIR', d, True)+"/tinder-machine.id", 'w')
    f.write(report)

def tinder_send_http(d, status, _log, test_name):
    """
    Send this log as build status
    """
    from bb import data


    # get the body and type
    server = data.getVar('TINDER_HOST', d, True )
    url    = data.getVar('TINDER_URL',  d, True )

    selector = url + "/xml/build_status.pl"

    # now post it - in chunks of 10.000 charachters
    new_log = _log
    while len(new_log) > 0:
        content_type, body = tinder_format_http_post(d,status,new_log[0:18000], test_name)
        errcode, errmsg, headers, h_file = tinder_http_post(server,selector,content_type, body)
        #print errcode, errmsg, headers
        #print h.file.read()
        new_log = new_log[18000:]


def tinder_print_info(d):
    """
    Print the TinderBox Info
        Including informations of the BaseSystem and the Tree
        we use.
    """

    from   bb import data
    import os
    # get the local vars

    time    = ""
    ops     = os.uname()[0]
    version = os.uname()[2]
    url     = data.getVar( 'TINDER_URL' , d, True )
    tree    = data.getVar( 'TINDER_TREE', d, True )
    branch  = data.getVar( 'TINDER_BRANCH', d, True )
    srcdate = data.getVar( 'SRCDATE', d, True )
    machine = data.getVar( 'MACHINE', d, True )
    distro  = data.getVar( 'DISTRO',  d, True )
    bbfiles = data.getVar( 'BBFILES', d, True )
    tarch   = data.getVar( 'TARGET_ARCH', d, True )
    fpu     = data.getVar( 'TARGET_FPU', d, True )
    oerev   = data.getVar( 'OE_REVISION', d, True ) or "unknown"

    # there is a bug with tipple quoted strings
    # i will work around but will fix the original
    # bug as well
    output = []
    output.append("== Tinderbox Info" )
    output.append("Time: %(time)s" )
    output.append("OS: %(ops)s" )
    output.append("%(version)s" )
    output.append("Compiler: BitTest" )
    output.append("Tinderbox Client: BitTest 0.1" )
    output.append("Tinderbox Client Last Modified: yesterday" )
    output.append("Tinderbox Protocol: 0.1" )
    output.append("URL: %(url)s" )
    output.append("Tree: %(tree)s" )
    output.append("Config:" )
    output.append("branch = '%(branch)s'" )
    output.append("TARGET_ARCH = '%(tarch)s'" )
    output.append("TARGET_FPU = '%(fpu)s'" )
    output.append("SRCDATE = '%(srcdate)s'" )
    output.append("MACHINE = '%(machine)s'" )
    output.append("DISTRO = '%(distro)s'" )
    output.append("BBFILES = '%(bbfiles)s'" )
    output.append("OEREV = '%(oerev)s'" )
    output.append("== End Tinderbox Client Info" )

    # now create the real output
    return "\n".join(output) % vars()

def tinder_print_env():
    """
    Print the environment variables of this build
    """
    from bb import data
    import os

    time_start = ""
    time_end   = ""

    # build the environment
    env = ""
    for var in os.environ:
        env += "%s=%s\n" % (var, os.environ[var])

    output = []
    output.append( "---> TINDERBOX RUNNING env %(time_start)s" )
    output.append( env )
    output.append( "<--- TINDERBOX FINISHED (SUCCESS) %(time_end)s" )

    return "\n".join(output) % vars()

def tinder_tinder_start(d, test_name):
    """
    PRINT the configuration of this build
    """

    config = tinder_print_info(d)
    #env    = tinder_print_env()
    time_start = ""
    time_end   = ""

    output = []
    output.append( "---> TINDERBOX PRINTING CONFIGURATION %(time_start)s" )
    output.append( config )
    #output.append( env    )
    output.append( "<--- TINDERBOX FINISHED PRINTING CONFIGURATION %(time_end)s" )
    output.append( "---> TINDERBOX TESTING '%(test_name)s'" )
    output.append( "<--- TINDERBOX STARTING TESTING NOW" )

    output.append( "" )

    return "\n".join(output) % vars()


class TestReportTinder:
    """
    Output the Test Result to a TinderBox
    """

    def __init__(self,config, test_name, file):
        self._config = config
        self.test_config = test_name
        self.test_file   = file

        # inform our box
        tinder_build_start(config, test_name)
        log  = tinder_tinder_start(config,test_name)
        tinder_send_http(config, 1, log, test_name)

    def init(self, test_result):
        self.test_result = test_result

    def print_result(self):
        """
        Now format the test results
            -Settle for 100 or 200 as status (sucess, failure)
            -Create one big log message
        """
        status = 100

        log  = "---> Printing the test results now\n"
        print >> self.test_file, "Test results for %s:\n"      % self.test_config
        print >> self.test_file, "\tNumber of ran tests: %d\n" % len(self.test_result)
        log += "<--- Done preparing\n"

        for test in self.test_result:
            log += "---> Test for %s\n" % test.tested_file()
            log += "Test comment: %s\n" % test.test_comment()
            log += "<--- Test finished (%s)\n" % test.test_result()

            if not test.test_result():
                status = 200

        # now send the log
        tinder_send_http(self._config, status, log, self.test_config)
