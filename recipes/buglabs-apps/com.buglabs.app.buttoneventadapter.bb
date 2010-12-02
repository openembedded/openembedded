require bug-app.inc

DESCRIPTION = "This bundle is an adapter that listens for button events and uses the whiteboard pattern to notify any interested services. More information about the whiteboard pattern can be found on the OSGi website."
HOMEPAGE = "http://buglabs.net/applications/buttoneventadapter"

DEPENDS += "com.buglabs.osgi service-tracker com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/135"

APIVERSION = ""
