require bug-app.inc

DESCRIPTION = "An example application that relies on the inotify API to send kernel log messages to clients."
HOMEPAGE = "http://buglabs.net/applications/KernelLogNotificationSource"

DEPENDS += "net.contentobjects.jnotify "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/1037"

APIVERSION = "1.4.3"
