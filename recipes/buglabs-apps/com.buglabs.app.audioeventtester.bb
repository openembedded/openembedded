require bug-app.inc

DESCRIPTION = "Simple app to test the audio module's interrupt handling.  If a jack is inserted into any of Headphone/Line-in/Line-out/Mic, the module's green LED will light up until it is removed.  This is also true for the buttons (press, LED lights, release, LED goes off).  \
Only works with R1.4"
HOMEPAGE = "http://buglabs.net/applications/AudioEventTester"

DEPENDS += "com.buglabs.bug.module.audio com.buglabs.bug.audio.common com.buglabs.common com.buglabs.osgi service-tracker "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/593"

APIVERSION = ""
