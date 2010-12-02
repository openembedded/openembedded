require bug-app.inc

DESCRIPTION = "Backlite is a simple program to change the LCD backlight.  The backlight has 3 modes:\
Low, Med, High.  Changing the value can be done two ways: a single click of the icon will cause the next highest setting and will loop back to lowest.  Holding down the icon for a few seconds and releasing will present the context menu for the application, and here too the setting can be changed.\
Requires LCD module, R1.4.1, and AppUI."
HOMEPAGE = "http://buglabs.net/applications/Backlite"

DEPENDS += "com.buglabs.bug.module.lcd com.buglabs.common service-tracker "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/684"

APIVERSION = "1.4.3"
