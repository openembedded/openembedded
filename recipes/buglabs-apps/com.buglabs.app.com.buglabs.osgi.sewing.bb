require bug-app.inc

DESCRIPTION = "This is the Simple Embedded Web framework for OSGi and the BUG.  It simplifies the creation of dynamic web applications and runs on PhoneME, BUG's mobile JVM.\
Sewing uses a template engine called 'fm-classic(fm-classic)':http://fm-classic.sourceforge.net/ (which is related to the popular 'freemarker(freemarker)':http://freemarker.org/ template engine).  The freemarker template source code is included in the bundle and, like this framework, is released under GPL.  See the source code for license information.  Note, only the basic template classes from fm-classic are included.  \
More information and documentation on fm-classic can be found here: 'http://fm-classic.sourceforge.net/(http://fm-classic.sourceforge.net/)':http://fm-classic.sourceforge.net/\
*The easiest way to use Sewing is to start with the SewingStubApplication which can be found here: 'http://buglabs.net/applications/SewingStubApplication(http://buglabs.net/applications/SewingStubApplication)':http://buglabs.net/applications/SewingStubApplication*\
If you have questions, jump on our IRC channel and ask me for help."
HOMEPAGE = "http://buglabs.net/applications/com.buglabs.osgi.sewing"

DEPENDS += "com.buglabs.osgi.http com.buglabs.osgi service-tracker com.sun.javax.servlet com.buglabs.common "

PV = "8"

SRC_LINK = "http://buglabs.net/program_version/download/919"

APIVERSION = ""
