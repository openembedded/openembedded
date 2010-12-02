require bug-app.inc

DESCRIPTION = "This app will turn off the backlight of BUG base and module LCDs if no activity within 15 seconds.  Backlights turn back on with button press and/or acceleration."
HOMEPAGE = "http://buglabs.net/applications/scnsvr"

DEPENDS += "service-tracker com.buglabs.common com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion com.buglabs.bug.module.lcd "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/816"

APIVERSION = ""
