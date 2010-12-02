require bug-app.inc

DESCRIPTION = "Prints the message 'Motion Event 1' then 'Motion Event 2' etc, on the BUG base LCD, as motion is detected. Adapted from BUGmotionHelloWorld (no, really?)."
HOMEPAGE = "http://buglabs.net/applications/BUGmotionHelloWorldWithCount"

DEPENDS += "com.buglabs.bug.module.motion com.buglabs.common com.buglabs.osgi service-tracker "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/1126"

APIVERSION = "1.4.3"
