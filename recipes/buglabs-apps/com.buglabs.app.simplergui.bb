require bug-app.inc

DESCRIPTION = "An update to SimpleGUI that uses ServiceTrackerHelper rather than AbstractServiceTracker.  This reduces the code in the Activator and completely removes the customizer class."
HOMEPAGE = "http://buglabs.net/applications/SimplerGUI"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/401"

APIVERSION = ""
