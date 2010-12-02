require bug-app.inc

DESCRIPTION = "This is a stub for begining a Sewing application.  Sewing is a simple web framework for embedded OSGi.  The Sewing framework can be found here: 'http://buglabs.net/applications/com.buglabs.osgi.sewing(http://buglabs.net/applications/com.buglabs.osgi.sewing)':http://buglabs.net/applications/com.buglabs.osgi.sewing\
To get started, download the Sewing framework and this application.  Rename this application and update the Bundle-Name in the manifest with the new name.  Then, start looking at the code.\
Start with the ServiceTracker, which registers a servlet in the doStart() method.  That servlet will contain most of your java code.  In the servlet, you define your controllers and map URLs to them.  These also correspond to freemarker (fml) templates in your templates directory.  There is some explanatory code in there to help you out and if you have questions, jump on IRC and ask.\
Lastly, for help with the templates, please check out the fm-classic site: 'http://fm-classic.sourceforge.net/(http://fm-classic.sourceforge.net/)':http://fm-classic.sourceforge.net/"
HOMEPAGE = "http://buglabs.net/applications/SewingStubApplication"

DEPENDS += "service-tracker com.buglabs.osgi com.buglabs.osgi.sewing com.sun.javax.servlet com.buglabs.common "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/830"

APIVERSION = ""
