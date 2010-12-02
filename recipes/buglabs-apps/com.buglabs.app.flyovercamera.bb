require bug-app.inc

DESCRIPTION = "FlyOver Camera lets you create a virtual flyover effect by moving the device in a vertical arc over any object or model.  Using the accelerometer to automatically calculate the position of the arc, it takes photos from all angles.  It then plays the angles back in a video on the display screen"
HOMEPAGE = "http://buglabs.net/applications/FlyOverCamera"

DEPENDS += "service-tracker com.buglabs.bug.module.motion com.buglabs.bug.module.lcd com.buglabs.bug.module.camera com.buglabs.common com.buglabs.bug.base com.buglabs.osgi "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/143"

APIVERSION = ""

BROKEN = "1"
