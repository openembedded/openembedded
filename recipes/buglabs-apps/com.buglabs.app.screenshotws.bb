require bug-app.inc

DESCRIPTION = "Screenshot Web service\
Access it by deploying it to your bug and going to http://10.10.10.10/service/screenshot\
"
HOMEPAGE = "http://buglabs.net/applications/ScreenShotWS"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/246"

APIVERSION = ""
