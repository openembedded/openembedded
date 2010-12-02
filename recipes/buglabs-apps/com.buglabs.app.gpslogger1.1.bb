require bug-app.inc

DESCRIPTION = "An updated version of GPSlogger by finsprings.  Currently under heavy development!\
Recent changes:\
- Map now pans to keep GPS location in center of display.\
- Map now tiles itself to fill all available area.\
- Interactive zoom control (buttons 1 and 2)\
- Typos fixed (works with SDK 248)\
- Now gives visual indication of heading\
"
HOMEPAGE = "http://buglabs.net/applications/GpsLogger_1.1"

DEPENDS += "com.buglabs.bug.module.gps com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "5"

SRC_LINK = "http://buglabs.net/program_version/download/42"

APIVERSION = ""

BROKEN = "1"
