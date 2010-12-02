require bug-app.inc

DESCRIPTION = "This app blinks lights on the base and any modules connected dynamically.  It throws out all BUG ServiceTracker abstractions and goes back to the basics to listen for new devices that have LEDs that can blink.  Currently this app requires R1.4 (not yet released) to blink LEDs on modules due to problems with R1.3."
HOMEPAGE = "http://buglabs.net/applications/XmasTree2"

DEPENDS += "com.buglabs.bug.base com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.vonhippel "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/429"

APIVERSION = ""
