require bug-app.inc

DESCRIPTION = "Application that notifies an AOL Instant Messenger (AIM) user of a motion detected event.  Sends the user the GPS information describing where the motion event occured.\
After the components are snapped in, the LCD screen calls for a valid AIM screen name and password, as well as valid target screen name.  \
Room for improvement: on screen LCD keyboard for login fields, more responsive GUI for login failures, etc."
HOMEPAGE = "http://buglabs.net/applications/AIMMotionNotifier"

DEPENDS += "com.buglabs.bug.module.gps com.buglabs.bug.module.lcd com.buglabs.bug.module.motion com.buglabs.common com.buglabs.osgi service-tracker "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/90"

APIVERSION = ""

BROKEN = "1"
