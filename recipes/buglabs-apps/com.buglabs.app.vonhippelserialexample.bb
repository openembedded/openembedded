require bug-app.inc

DESCRIPTION = "Simple app to set the serial port baud rate for the slot that the von hippel module is plugged into.  In this case, it sets it to 19200 and write data to it for 100 seconds."
HOMEPAGE = "http://buglabs.net/applications/VonHippelSerialExample"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.vonhippel "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/1044"

APIVERSION = ""
