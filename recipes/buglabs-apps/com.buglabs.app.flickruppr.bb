require bug-app.inc

DESCRIPTION = "Detects motion, takes a snapshot, geo-tags it, and uploads it to user's flickr account. Uses Camera, GPS, Motion and Display modules."
HOMEPAGE = "http://buglabs.net/applications/FlickrUppr"

DEPENDS += "service-tracker com.buglabs.bug.module.motion com.buglabs.bug.module.lcd com.buglabs.bug.module.camera com.buglabs.common com.buglabs.bug.module.gps com.buglabs.osgi "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/40"

APIVERSION = ""

BROKEN = "1"
