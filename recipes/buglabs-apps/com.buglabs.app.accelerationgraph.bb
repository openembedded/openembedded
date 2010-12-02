require bug-app.inc

DESCRIPTION = "This app exposes a web service (or rather a page) that displays g-force value. It is refreshed every three seconds. \
The service is accessible at: *http://your_bug/service/AcceleratorGraph*"
HOMEPAGE = "http://buglabs.net/applications/AccelerationGraph"

DEPENDS += "com.buglabs.osgi com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion service-tracker com.buglabs.common "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/969"

APIVERSION = "1.4.2"
