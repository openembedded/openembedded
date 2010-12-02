require bug-app.inc

DESCRIPTION = "Still in the developmental stage.  Need help determining the amount of time that has passed as I'm assuming that System.currentTimeMillis() does not work on the bug.  Runs ok on the virtual bug but the real one calculates increasing velocity when it is stationary.  \
Description:  Simple speedometer application.  Uses the trapezoidal rule to create an approximation of area under the acceleration curve.  Has 3 buttons to change the units between mph, m/s, ft/s."
HOMEPAGE = "http://buglabs.net/applications/Speedometer"

DEPENDS += "com.buglabs.osgi com.buglabs.common com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion service-tracker com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/588"

APIVERSION = ""
