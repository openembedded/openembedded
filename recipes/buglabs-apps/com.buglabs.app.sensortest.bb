require bug-app.inc

DESCRIPTION = "Tests the various sensors on the sensor module.\
Currently there are tests for:\
* LEDs\
* Temperature\
* Humidity\
* Compass\
On startup it defaults to testing them all one after another, then looping.\
If you press HK1 it will just loop the LED test; press it again and it will just loop the Temperature test, and so on.\
The BUG LCD is used to display data for the test that's being run, and for transition messages when you press HK1. So if you are in Humidity test and press HK1 the LCD will briefly show '-> CMP' then it will start showing Hx and Hy values from the compass. This allows you to test without being tethered to a handylink.\
HK2 will start/stop a compass calibration. During compass calibration the red and green LEDs on the sensor module will both light up. To calibrate the compass, press HK2, observe the LEDs light up then slowly rotate the BUG base at least 360 degrees. As you do this the sensor module is tracking  the min/max Hx and Hy readings. When you're done, press HK2 to stop the calibration. At this point the LEDs will turn off and the observed min/max readings will be used to calculate the zero points for the X and Y axes. You should find that rotating the BUG 360 results in an equivalent change in heading now.\
"
HOMEPAGE = "http://buglabs.net/applications/SensorTest"

DEPENDS += "com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion com.buglabs.bug.module.sensor com.buglabs.common com.buglabs.osgi service-tracker "

PV = "27"

SRC_LINK = "http://buglabs.net/program_version/download/1128"

APIVERSION = ""
