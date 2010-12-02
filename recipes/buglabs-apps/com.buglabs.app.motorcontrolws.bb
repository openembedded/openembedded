require bug-app.inc

DESCRIPTION = "This provides a simple webform control for the IContinuousMotorController, (Provided by the  'ContinuousMotorController':http://buglabs.net/applications/ContinuousMotorController) so that you can drive a differential steering robot around. The way I have it running right now, put your BUG on the wifi network and navigate to http://(your Bug's IP address)/service/motorcontroller on your laptop or iPhone and drive the robot around. "
HOMEPAGE = "http://buglabs.net/applications/MotorControlWS"

DEPENDS += "com.buglabs.osgi com.buglabs.app.continuousmotorcontroller service-tracker com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/514"

APIVERSION = ""

BROKEN = "1"
