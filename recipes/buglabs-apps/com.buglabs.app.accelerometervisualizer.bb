require bug-app.inc

DESCRIPTION = "h4. Description \
A BUGapp that shows a window on LCD screen the accelerometer data. The display have 3 axis that shows what G's are currently being returned. \
This app shows some cool features of  'LWUITMB(LWUITMB)':http://lwuimb.thenesis.org/bin/view/Main/ \
"
HOMEPAGE = "http://buglabs.net/applications/AccelerometerVisualizer"

DEPENDS += "com.buglabs.osgi com.buglabs.common com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion service-tracker com.buglabs.bug.module.lcd "

PV = "5"

SRC_LINK = "http://buglabs.net/program_version/download/655"

APIVERSION = ""

BROKEN = "1"
