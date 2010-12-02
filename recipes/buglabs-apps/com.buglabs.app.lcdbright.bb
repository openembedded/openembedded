require bug-app.inc

DESCRIPTION = "Simple App that sets LCD module backlight via BUGbase hot keys\
HotKey 1 = high\
HotKey 2 = med\
HotKey 3 = low\
HotKey 4 = off"
HOMEPAGE = "http://buglabs.net/applications/LCDbright"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/1047"

APIVERSION = "1.4.1"
