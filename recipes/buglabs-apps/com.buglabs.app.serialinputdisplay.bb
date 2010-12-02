require bug-app.inc

DESCRIPTION = "A simple debugging tool that displays serial input on the LCD module's screen. It will display the raw integer values. \
Default baud rate is 9600, but can be reset. \
This application is useful for verifying circuits/sensors/devices are correctly sending RS232 level serial data to the BUG, and as a starting point for a full featured application based around serial input. "
HOMEPAGE = "http://buglabs.net/applications/SerialInputDisplay"

DEPENDS += "com.buglabs.osgi com.buglabs.bug.module.vonhippel com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/906"

APIVERSION = "1.4"

BROKEN = "1"
