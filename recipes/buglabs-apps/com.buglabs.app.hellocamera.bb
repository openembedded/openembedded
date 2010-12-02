require bug-app.inc

DESCRIPTION = "A demonstration that takes a picture with the camera when you hold it still for a little while. Image is shown on the LCD (not saved)."
HOMEPAGE = "http://buglabs.net/applications/hellocamera"

DEPENDS += "service-tracker com.buglabs.bug.module.motion com.buglabs.bug.module.lcd com.buglabs.bug.module.camera com.buglabs.common com.buglabs.osgi com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/658"

APIVERSION = ""
