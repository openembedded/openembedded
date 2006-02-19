def tinder_form_data(bound, dict, log):
    """
    Create the boundary for the HTTP Post
    """
    output = []

    # for each key in the dictionary
    for name in dict:
        output.append( "--" + bound )
        output.append( 'Content-Disposition: form-data; name="%s"' % name )
        output.append( "" )
        output.append( dict[name] )
    if log:
        output.append( "--" + bound )
        output.append( 'Content-Disposition: form-data; name="log"; filename="log.txt"' )
        output.append( '' )
        output.append( log )
    output.append( '--' + bound + '--' )
    output.append( '' )

    return "\r\n".join(output)

def tinder_send_http(d, log):
    """
    Send the log via HTTP...
    """

def tinder_time_string():
    """
    Return the time as GMT
    """
    return ""

def tinder_format_http_post(d,log):
    """
    Format the Tinderbox HTTP post with the data needed
    for the tinderbox to be happy.
    """

    from bb import data
    import os,random

    # the variables we will need to send on this form post
    variables =  {
        "tree"         : data.getVar('TINDER_TREE',    d, True),
        "machine_name" : data.getVar('TINDER_MACHINE', d, True),
        "os"           : os.uname()[0],
        "os_version"   : os.uname()[2],
        "compiler"     : "gcc",
        "clobber"      : data.getVar('TINDER_CLOBBER', d, True)
    }

    # the boundary we will need
    boundary = "----------------------------------%d" % int(random.random()*1000000000000)

    # now format the body
    body = tinder_form_data( boundary, variables, log )

    return ("multipart/form-data; boundary=%s" % boundary),body


def tinder_build_start(d):
    """
    Inform the tinderbox that a build is starting. We do this
    by posting our name and tree to the build_start.pl script
    on the server.
    """
    from bb import data
    import httplib

    # get the body and type
    content_type, body = tinder_format_http_post(d,None)
    server = data.getVar('TINDER_HOST', d, True )
    url    = data.getVar('TINDER_URL',  d, True )

    selector = url + "/xml/build_start.pl"

    print "selector %s and url %s" % (selector, url)

    # now post it
    h = httplib.HTTP(server)
    h.putrequest('POST', selector)
    h.putheader('content-type', content_type)
    h.putheader('content-length', str(len(body)))
    h.endheaders()
    h.send(body)
    errcode, errmsg, headers = h.getreply()
    print errcode, errmsg, headers
    print h.file.read()

    print body
    print content_type

def tinder_print_info(d):
    """
    Print the TinderBox Info
        Including informations of the BaseSystem and the Tree
        we use.
    """

    from   bb import data
    import os
    # get the local vars

    time    = tinder_time_string()
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

    # there is a bug with tipple quoted strings
    # i will work around but will fix the original
    # bug as well
    output = []
    output.append("== Tinderbox Info" )
    output.append("Time: %(time)s" )
    output.append("OS: %(ops)s" )
    output.append("%(version)s" )
    output.append("Compiler: gcc" )
    output.append("Tinderbox Client: 0.1" )
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
    output.append("== End Tinderbox Client Info" )

    # now create the real output
    return "\n".join(output) % vars()


def tinder_print_env():
    """
    Print the environment variables of this build
    """
    from bb import data
    import os

    time_start = tinder_time_string()
    time_end   = tinder_time_string()

    # build the environment
    env = ""
    for var in os.environ:
        env += "%s=%s\n" % (var, os.environ[var])

    output = []
    output.append( "---> TINDERBOX RUNNING env %(time_start)s" )
    output.append( env )
    output.append( "<--- TINDERBOX FINISHED (SUCCESS) %(time_end)s" )

    return "\n".join(output) % vars()

def tinder_tinder_start(d):
    """
    PRINT the configuration of this build
    """

    time_start = tinder_time_string()
    config = tinder_print_info(d)
    env    = tinder_print_env()
    time_end   = tinder_time_string()

    output = []
    output.append( "---> TINDERBOX PRINTING CONFIGURATION %(time_start)s" )
    output.append( config )
    output.append( env    )
    output.append( "<--- TINDERBOX FINISHED PRINTING CONFIGURATION %(time_end)s" )
    return "\n".join(output) % vars()

def tinder_do_tinder_report(event):
    """
    Report to the tinderbox. Either we will report every step
    (depending on TINDER_VERBOSE_REPORT) at the end we will send the
    tinderclient.log
    """
    from bb.event import getName
    from bb import data, mkdirhier
    import os, glob

    # variables
    name = getName(event)
    log  = ""
    logfile = None

    # Check what we need to do Build* shows we start or are done
    if name == "BuildStarted":
        tinder_build_start(event.data)
        log = tinder_tinder_start(event.data)

    if name == "PkgFailed" or name == "BuildCompleted":
        status = 'build_failed'
        if name == "BuildCompleted":
            status = "success"
        # append the log
        log_file = data.getVar('TINDER_LOG', event.data, True)
        file     = open(log_file, 'r')
        for line in file.readlines():
            log += line

    if verbose and name == "TaskStarted":
        log    = "Task %s started" % event.task

    if verbose and name == "PkgStarted":
        log    = "Package %s started" % data.getVar('P', event.data, True)

    if verbose and name == "PkgSucceeded":
        header = tinder_prepare_mail_header(event.data, 'building')
        log    = "Package %s done" % data.getVar('P', event.data, True)

    # Append the Task Log
    if name == "TaskSucceeded" or name == "TaskFailed":
        log_file = glob.glob("%s/log.%s.*" % (data.getVar('T', event.data, True), event.task))

        if len(log_file) != 0:
            to_file  = data.getVar('TINDER_LOG', event.data, True)
            log_txt  = open(log_file[0], 'r').readlines()
            to_file.writelines(log_txt)

            # append to the log
            if verbose:
                header = tinder_prepare_mail_header(event.data, 'building')
                for line in log_txt:
                    log += line

    # now post the log
    if len(log) == 0:
        return

    # for now we will use the http post method as it is the only one
    log_post_method = tinder_send_http
    log_post_method(event.data, log)


# we want to be an event handler
addhandler tinderclient_eventhandler
python tinderclient_eventhandler() {
    from bb import note, error, data
    from bb.event import NotHandled

    do_tinder_report = data.getVar('TINDER_REPORT', e.data, True)
    if do_tinder_report and do_tinder_report == "1":
        tinder_do_tinder_report(e)

    return NotHandled
}
