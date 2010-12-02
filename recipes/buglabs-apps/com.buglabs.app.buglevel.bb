require bug-app.inc

DESCRIPTION = "Implements a level using the accelerometer in the BUGmotion module. Warning: Using APIs not yet available from SDK."
HOMEPAGE = "http://buglabs.net/applications/BUGLevel"

DEPENDS += "com.buglabs.bug.base com.buglabs.osgi com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion service-tracker com.buglabs.common "

PV = "8"

SRC_LINK = "http://buglabs.net/program_version/download/210"

APIVERSION = ""
