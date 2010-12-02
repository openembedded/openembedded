require bug-app.inc

DESCRIPTION = "A hello world app for the BUGview.  Based on kschultz's SimpleGUI.  This example prints text to a window on the screen and uses the BUGview's built in accelerometer to find its orientation.\
Note:  Will not run on the Virtual BUG in the current SDK (1.0.0.6) because the SDK does not expose IAccelerometerSampleProvider when the LCD is installed.  This should be fixed in a later release."
HOMEPAGE = "http://buglabs.net/applications/BUGviewHelloWorld"

DEPENDS += "com.buglabs.osgi com.buglabs.common com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion service-tracker com.buglabs.bug.module.lcd "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/296"

APIVERSION = ""
