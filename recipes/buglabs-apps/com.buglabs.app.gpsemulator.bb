require bug-app.inc

DESCRIPTION = "For those that don't want to spend time creating specific GPS log files.  Emulates the GPS module (registers an IPositionProvider service) with configurable, time-based paths.  All path implementations work 'out of the box' using defaults or can be configured using system properties.\
1.1.0 - Added a random path implementation and made it the default path.\
1.0.0 - Initial release.  Includes a circular path and a straight line path.  Not extensively tested for accuracy of GPS calculations, especially over large distances or long running tasks."
HOMEPAGE = "http://buglabs.net/applications/GpsEmulator"

DEPENDS += "com.buglabs.bug.module.gps com.buglabs.common "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/59"

APIVERSION = ""
