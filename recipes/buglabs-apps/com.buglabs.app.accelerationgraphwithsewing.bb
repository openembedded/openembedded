require bug-app.inc

DESCRIPTION = "This is the same app as 'AccelerationGraph':http://www.buglabs.net/applications/AccelerationGraph except that it's created using 'com.buglabs.osgi.sewing':http://www.buglabs.net/applications/com.buglabs.osgi.sewing. \
The service is accessible at: *http://your_bug/AccelerationGraphviaSewing*"
HOMEPAGE = "http://buglabs.net/applications/AccelerationGraphWithSewing"

DEPENDS += "service-tracker com.buglabs.osgi com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion com.buglabs.osgi.sewing com.sun.javax.servlet com.buglabs.common "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/996"

APIVERSION = "1.4.2"
