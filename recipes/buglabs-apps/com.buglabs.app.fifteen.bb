require bug-app.inc

DESCRIPTION = "Implementation of fifteen puzzle game using accelerometer and on-screen controls. WARNING: Code that depends on accelerometer has not been tested with physical BUGBase."
HOMEPAGE = "http://buglabs.net/applications/Fifteen"

DEPENDS += "service-tracker com.buglabs.bug.module.motion com.buglabs.bug.module.lcd com.buglabs.bug.module.camera com.buglabs.common com.buglabs.bug.base com.buglabs.osgi "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/177"

APIVERSION = ""

BROKEN = "1"
