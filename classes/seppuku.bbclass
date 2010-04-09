#
# Small event handler to automatically open URLs and file
# bug reports at a bugzilla of your choiche
#
# This class requires python2.4 because of the urllib2 usage
#

def seppuku_spliturl(url):
    """
    Split GET URL to return the host base and the query
    as a param dictionary
    """
    import urllib
    (uri,query)  = urllib.splitquery(url)
    param = {}
    for par in query.split("&"):
        (key,value) = urllib.splitvalue(par)
        if not key or len(key) == 0 or not value:
            continue
        key = urllib.unquote(key)
        value = urllib.unquote(value)
        param[key] = value

    return (uri,param)



def seppuku_login(opener, login, user, password):
    """
    We need to post to query.cgi with the parameters
    Bugzilla_login and Bugzilla_password and will scan
    the resulting page then

    @param opened = cookie enabled urllib2 opener
    @param login = http://bugs.openembedded.net/query.cgi?
    @param user  = Your username
    @param password  = Your password
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

def seppuku_find_bug_report_old():
    from HTMLParser import HTMLParser

    class BugQueryExtractor(HTMLParser):
        STATE_NONE             = 0
        STATE_FOUND_TR         = 1
        STATE_FOUND_NUMBER     = 2
        STATE_FOUND_PRIO       = 3
        STATE_FOUND_PRIO2      = 4
        STATE_FOUND_NAME       = 5
        STATE_FOUND_PLATFORM   = 6
        STATE_FOUND_STATUS     = 7
        STATE_FOUND_WHATEVER   = 8 # I don't know this field
        STATE_FOUND_DESCRIPTION =9

        def __init__(self):
            HTMLParser.__init__(self)
            self.state = self.STATE_NONE
            self.bugs = []
            self.bug  = None

        def handle_starttag(self, tag, attr):
            if self.state == self.STATE_NONE and tag.lower() == "tr":
                if len(attr) == 1 and attr[0][0] == 'class' and \
                    ('bz_normal' in attr[0][1] or 'bz_blocker' in attr[0][1] or 'bz_enhancement' in attr[0][1] or 'bz_major' in attr[0][1] or 'bz_minor' in attr[0][1] or 'bz_trivial' in attr[0][1] or 'bz_critical' in attr[0][1] or 'bz_wishlist' in attr[0][1]) \
                    and 'bz_P' in attr[0][1]:
                    self.state = self.STATE_FOUND_TR
            elif self.state == self.STATE_FOUND_TR and tag.lower() == "td":
                self.state += 1

        def handle_endtag(self, tag):
            if tag.lower() == "tr":
                if self.state != self.STATE_NONE:
                    self.bugs.append( (self.bug,self.status) )
                self.state = self.STATE_NONE
                self.bug  = None
            if self.state > 1 and tag.lower() == "td":
                self.state += 1

        def handle_data(self,data):
            data = data.strip()

            # skip garbage
            if len(data) == 0:
                return

            if self.state == self.STATE_FOUND_NUMBER:
                """
                #1995 in bugs.oe.org has [SEC] additionally to the number and we want to ignore it
                """
                if not self.bug:
                    self.bug = data
            elif self.state == self.STATE_FOUND_STATUS:
                self.status = data

        def result(self):
            return self.bugs

    return BugQueryExtractor()



def seppuku_find_bug_report(debug_file, opener, query, product, component, bugname):
    """
    Find a bug report with the sane name and return the bug id
    and the status.

    @param opener = urllib2 opener
    @param query  = e.g. http://bugs.openembedded.net/query.cgi?
    @param product = search for this product
    @param component = search for this component
    @param bugname = the bug to search for

    http://bugs.openembedded.net/buglist.cgi?short_desc_type=substring&short_desc=manual+test+bug&product=Openembedded&emailreporter2=1&emailtype2=substring&email2=freyther%40yahoo.com
    but it does not support ctype=csv...
    """
    import urllib
    product   = urllib.quote(product)
    component = urllib.quote(component)
    bugname   = urllib.quote(bugname)

    file = "%(query)sproduct=%(product)s&component=%(component)s&short_desc_type=substring&short_desc=%(bugname)s" % vars()
    print >> debug_file, "Trying %s" % file
    result = opener.open(file)
    if result.code != 200:
        raise "Can not query the bugzilla at all"
    txt = result.read()
    scanner = seppuku_find_bug_report_old()
    scanner.feed(txt)
    if len(scanner.result()) == 0:
        print >> debug_file, "Scanner failed to scan the html site"
        print >> debug_file, "%(query)sproduct=%(product)s&component=%(component)s&short_desc_type=substring&short_desc=%(bugname)s" % vars()
        #print >> debug_file, txt
        return (False,None)
    else: # silently pick the first result
        print >> debug_file, "Result of bug search is "
        #print >> debug_file, txt
        (number,status) = scanner.result()[0]
        return (not status in ["CLOS", "RESO", "VERI"],number)

def seppuku_reopen_bug(poster, file, product, component, bug_number, bugname, text):
    """
    Reopen a bug report and append to the comment

    Same as with opening a new report, some bits need to be inside the url

    http://bugs.openembedded.net/process_bug.cgi?id=239&bug_file_loc=http%3A%2F%2F&version=Angstrom&longdesclength=2&product=Openembedded&component=Build&comment=bla&priority=P2&bug_severity=normal&op_sys=Linux&rep_platform=Other&knob=reopen&short_desc=foo
    """

    import urllib2
    (uri, param) = seppuku_spliturl( file )

    # Prepare the post
    param["product"]        = product
    param["component"]      = component
    param["longdesclength"] = 2
    param["short_desc"]     = bugname
    param["knob"]           = "reopen"
    param["id"]             = bug_number
    param["comment"]        = text

    try:
        result = poster.open( uri, param )
    except urllib2.HTTPError, e:
        print e.geturl()
        print e.info()
        return False
    except Exception, e:
        print e
        return False

    if result.code != 200:
        return False
    else:
        return True

def seppuku_file_bug(poster, file, product, component, bugname, text):
    """
    Create a completely new bug report


    http://bugs.openembedded.net/post_bug.cgi?bug_file_loc=http%3A%2F%2F&version=Angstrom&product=Openembedded&component=Build&short_desc=foo&comment=bla&priority=P2&bug_severity=normal&op_sys=Linux&rep_platform=Other

    You are forced to add some default values to the bugzilla query and stop with '&'

    @param opener  urllib2 opener
    @param file    The url used to file a bug report
    @param product Product
    @param component Component
    @param bugname  Name of the to be created bug
    @param text Text
    """

    import urllib2
    (uri, param) = seppuku_spliturl( file )
    param["product"]    = product
    param["component"]  = component
    param["short_desc"] = bugname
    param["comment"]    = text

    try:
        result = poster.open( uri, param )
    except urllib2.HTTPError, e:
        print e.geturl()
        print e.info()
        return False
    except Exception, e:
        print e
        return False

    # scan the result for a bug number
    # it will look like 
    # '<title>Bug 2742 Submitted</title>'
    import re
    res = re.findall(("\>Bug (?P<int>\d+) Submitted"), result.read() )
    if result.code != 200 or len(res) != 1:
        return None 
    else:
        return res[0] 

def seppuku_create_attachment(data, debug, poster, attach_query, product, component, bug_number, text, file):
    """

    Create a new attachment for the failed report
    """

    if not bug_number:
        import bb
        bb.note("Can't create an attachment, no bugnumber passed to method")
        print >> debug, "Can't create an attachment, no bugnumber passed to method"
	return False

    if not attach_query:
        import bb
        bb.note("Can't create an attachment, no attach_query passed to method")
        print >> debug, "Can't create an attachment, no attach_query passed to method"
        return False

    import bb
    logdescription = "Build log for machine %s" % (bb.data.getVar('MACHINE', data, True))

    import urllib2
    param = { "bugid" : bug_number, "action" : "insert", "data" : file, "description" : logdescription, "ispatch" : "0", "contenttypemethod" : "list", "contenttypeselection" : "text/plain", "comment" : text }

    try:
        result = poster.open( attach_query, param )
    except urllib2.HTTPError, e:
        print e.geturl()
        print e.info()
        return False
    except Exception, e:
        print e
        print >> debug, "Got exception in poster.open( attach_query, param )"
	print >> debug, "attach_query: %s  param: %s" % (attach_query, param )
	return False

    txt = result.read()
    if result.code != 200:
        print >> debug, "Got bad return code (%s)" % result.code
        return False
    else:
        print >> debug, "Got good return code (200)" 
        return True


addhandler seppuku_eventhandler
python seppuku_eventhandler() {
    """
    Report task failures to the bugzilla
    and succeeded builds to the box
    """
    from bb.event import getName
    from bb import data, mkdirhier, build
    import bb, os, glob

    event = e
    data = e.data
    name = getName(event)
    if name == "MsgNote":
       # avoid recursion
       return

    # Try to load our exotic libraries
    try:
        import MultipartPostHandler
    except:
        bb.note("You need to put the MultipartPostHandler into your PYTHONPATH. Download it from http://pipe.scs.fsu.edu/PostHandler/MultipartPostHandler.py")
        return

    try:
        import urllib2, cookielib
    except:
        bb.note("Failed to import the cookielib and urllib2, make sure to use python2.4")
        return

    if name == "PkgFailed":
        if not bb.data.getVar('SEPPUKU_AUTOBUILD', data, True) == "0":
            build.exec_func('do_clean', data)
    elif name == "TaskFailed":
        cj = cookielib.CookieJar()
        opener  = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj))
        poster  = urllib2.build_opener(urllib2.HTTPCookieProcessor(cj),MultipartPostHandler.MultipartPostHandler)
        login   = bb.data.getVar("SEPPUKU_LOGIN", data, True)
        query   = bb.data.getVar("SEPPUKU_QUERY", data, True)
        newbug  = bb.data.getVar("SEPPUKU_NEWREPORT",  data, True)
        reopen  = bb.data.getVar("SEPPUKU_ADDCOMMENT",  data, True)
        attach  = bb.data.getVar("SEPPUKU_ATTACHMENT", data, True)
        user    = bb.data.getVar("SEPPUKU_USER",  data, True)
        passw   = bb.data.getVar("SEPPUKU_PASS",  data, True)
        product = bb.data.getVar("SEPPUKU_PRODUCT", data, True)
        component = bb.data.getVar("SEPPUKU_COMPONENT", data, True)
	proxy	= bb.data.getVar('HTTP_PROXY', data, True )
	if (proxy):
		phl = urllib2.ProxyHandler({'http' : proxy})
		poster.add_handler(phl)
		opener.add_handler(phl)

        # evil hack to figure out what is going on
        debug_file = open(os.path.join(bb.data.getVar("TMPDIR", data, True),"..","seppuku-log"),"a")

        if not seppuku_login(opener, login, user, passw):
            bb.note("Login to bugzilla failed")
            print >> debug_file, "Login to bugzilla failed"
            return
        else:
            print >> debug_file, "Logged into the box"

        file = None
        if name == "TaskFailed":
            bugname = "%(package)s-%(pv)s-autobuild" % { "package" : bb.data.getVar("PN", data, True),
                                                               "pv"      : bb.data.getVar("PV", data, True),
                                                               }  
            log_file = glob.glob("%s/log.%s.*" % (bb.data.getVar('T', event.data, True), event.task))
            text     = "The %s step in %s failed at %s for machine %s" % (e.task, bb.data.getVar("PN", data, True), bb.data.getVar('DATETIME', data, True), bb.data.getVar( 'MACHINE', data, True ) )
            if len(log_file) != 0:
                print >> debug_file, "Adding log file %s" % log_file[0]
                file = open(log_file[0], 'r')
            else:
                print >> debug_file, "No log file found for the glob"
        else:
            print >> debug_file, "Unknown name '%s'" % name
            assert False

        (bug_open, bug_number) = seppuku_find_bug_report(debug_file, opener, query, product, component, bugname)
        print >> debug_file, "Bug is open: %s and bug number: %s" % (bug_open, bug_number)

        # The bug is present and still open, attach an error log
        if bug_number and bug_open:
            print >> debug_file, "The bug is known as '%s'" % bug_number
            if file:
                if not seppuku_create_attachment(data, debug_file, poster, attach, product, component, bug_number, text, file):
                     print >> debug_file, "Failed to attach the build log for bug #%s" % bug_number
                else:
                     print >> debug_file, "Created an attachment for '%s' '%s' '%s'" % (product, component, bug_number)
            else:
                     print >> debug_file, "Not trying to create an attachment for bug #%s" % bug_number
            return

        if bug_number and not bug_open:
            if not seppuku_reopen_bug(poster, reopen, product, component, bug_number, bugname, text):
                print >> debug_file, "Failed to reopen the bug #%s" % bug_number
            else:
                print >> debug_file, "Reopened the bug #%s" % bug_number
        else:	
            bug_number = seppuku_file_bug(poster, newbug, product, component, bugname, text)
            if not bug_number:
                print >> debug_file, "Couldn't acquire a new bug_numer, filing a bugreport failed"
            else:
                print >> debug_file, "The new bug_number: '%s'" % bug_number

        if bug_number and file:
            if not seppuku_create_attachment(data, debug_file, poster, attach, product, component, bug_number, text, file):
                print >> debug_file, "Failed to attach the build log for bug #%s" % bug_number
            else:
                print >> debug_file, "Created an attachment for '%s' '%s' '%s'" % (product, component, bug_number)
        else:
            print >> debug_file, "Not trying to create an attachment for bug #%s" % bug_number

        # store bug number for oestats-client
        if bug_number:
            bb.data.setVar('OESTATS_BUG_NUMBER', bug_number, event.data)
            bb.data.setVar('OESTATS_BUG_TRACKER', "http://bugs.openembedded.net/", event.data)
}
