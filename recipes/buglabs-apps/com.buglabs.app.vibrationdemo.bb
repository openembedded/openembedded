require bug-app.inc

DESCRIPTION = "This Demo shows how to use the ShakeMeasuereService. \
It constantly reads information from the accelerometer and turn on/off  LDE's depending  of the shaking intensity. Download both this application and ShakeMeasuereService."
HOMEPAGE = "http://buglabs.net/applications/VibrationDemo"

DEPENDS += "service-tracker com.buglabs.app.shakemeasureservice com.buglabs.common com.buglabs.bug.base com.buglabs.osgi com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion "

PV = "6"

SRC_LINK = "http://buglabs.net/program_version/download/708"

APIVERSION = ""
