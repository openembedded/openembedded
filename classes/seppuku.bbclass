#
# Small event handler to automatically open URLs and file
# bug reports at a bugzilla of your choiche
#
# This class requires python2.4 because of the urllib2 usage
#


def seppuku_login(opener, login, user, password):
    """
    We need to post to query.cgi with the parameters
    Bugzilla_login and Bugzilla_password and will scan
    the resulting page then

    @param opened = cookie enabled urllib2 opener
    @param login = http://bugzilla.openmoko.org/cgi-bin/bugzilla/query.cgi?
    @param user  = Your username
    @param pass  = Your password
    """
    import urllib
    param = urllib.urlencode( {"GoAheadAndLogIn" : 1, "Bugzilla_login" : user, "Bugzilla_password" : password } )
    result = opener.open(login + param)

    if result.code != 200:
        return False
    txt = result.read()
    if not '<a href="relogin.cgi">Log&nbsp;out</a>' in txt:
        return False

    return True


def seppuku_find_bug_report(opener, query, product, component, bugname):
    """
    Find a bug report with the sane name and return the bug id
    and the status.

    @param opener = urllib2 opener
    @param query  = e.g. https://bugzilla.openmoko.org/cgi-bin/bugzilla/query.cgi?
    @param product = search for this product
    @param component = search for this component
    @param bugname = the bug to search for

    https://bugzilla.openmoko.org/cgi-bin/bugzilla/buglist.cgi?short_desc_type=substring&short_desc=manual+test+bug&product=OpenMoko&emailreporter2=1&emailtype2=substring&email2=freyther%40yahoo.com
    but it does not support ctype=csv...
    """
    pass

def seppuku_append_or_file(opener, file, product, component, bugname, text):
    """
    Add a comment or open a bug report
    """



addhandler seppuku_do_report
python seppuku_do_report() {
    """
    Report task failures to the bugzilla
    and succeeded builds to the box
    """
    from bb.event import NotHandled, getName
    from bb import data, mkdirhier, build
    import bb, os, glob

    try:
        import urllib2, cookielib
    except:
        bb.note("Failed to import the cookielib and urllib2, make sure to use python2.4")
        return NotHandled

    event = e
    data = e.data
    name = getName(event)
    if name == "PkgFailed":
        if not data.getVar('SEPPUKU_AUTOBUILD', data, True) == "0":
            build.exec_task('do_clean', data)
    elif name == "TaskFailed" or name == "NoProvider":
        cj = cookielib.CookieJar()
        opener  = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj))
        login   = bb.data.getVar("SEPPUKU_LOGIN", data, True)
        query   = bb.data.getVar("SEPPUKU_QUERY", data, True)
        file    = bb.data.getVar("SEPPUKU_FILE",  data, True)
        post    = bb.data.getVar("SEPPUKU_POST",  data, True)
        user    = bb.data.getVar("SEPPUKU_USER",  data, True)
        pass    = bb.data.getVar("SEPPUKU_PASS",  data, True)
        product = bb.data.getVar("SEPPUKU_PRODUCT", data, True)
        component = bb.data.getVar("SEPPUKU_COMPONENT", data, True)

        if not seppuku_login(opener, login, user, pass):
            bb.note("Login to bugzilla failed")
            return NotHandled

        if name == "TaskFailed":
            bugname = "%(package)s-%(pv)s-%(pr)s-%(task)s" % { "package" : bb.data.getVar("PN", data, True),
                                                               "pv"      : bb.data.getVar("PV", data, True),
                                                               "pr"      : bb.data.getVar("PR", data, True),
                                                               "task"    : e.task }
            log_file = glob.glob("%s/log.%s.*" % (data.getVar('T', event.data, True), event.task))
            if len(log_file) != 0:
                to_file  = data.getVar('TINDER_LOG', event.data, True)
            text    = "".join(open(log_file[0], 'r').readlines())
        elif name == "NoProvider":
            bugname = "noprovider for %s runtime: %s" % (event.getItem, event.getisRuntime)
            text    = "Please fix it"
        else
            assert False

        (bug_open, bug_number) = seppuku_find_bug_report(opener, query, product, component, bugname)

        # The bug is present and still open, no need to attach an error log
        if bug_nunumber and bug_open:
            return NotHandled


        if seppuku_append_or_file(opener, file, produuct, component, bugname, text)
            bb.note("Filing a bugreport failed")

    return NotHandled
