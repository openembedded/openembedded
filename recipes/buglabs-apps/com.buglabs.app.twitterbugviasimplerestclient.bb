require bug-app.inc

DESCRIPTION = "This is the same thing as David's TwitterBug  only it uses SimpleRESTClient to handle the communication with Twitter's web services.\
I simply modified one of David's functions, TwitterBugApp::twitterLogin to use SimpleRESTClient as an example of how to use SimpleRESTClient."
HOMEPAGE = "http://buglabs.net/applications/TwitterBug_viaSimpleRESTClient"

DEPENDS += "com.buglabs.app.simplerestclient com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/230"

APIVERSION = ""
