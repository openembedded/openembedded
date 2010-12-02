require bug-app.inc

DESCRIPTION = "Display weather information based on BUG's location. \
Note: You will need to download LatLonConverter in order to run BUGWeather."
HOMEPAGE = "http://buglabs.net/applications/BUGWeather"

DEPENDS += "com.buglabs.app.latlonconverter com.buglabs.bug.module.gps com.buglabs.bug.module.lcd com.buglabs.common com.buglabs.osgi service-tracker "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/37"

APIVERSION = ""
