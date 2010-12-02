require bug-app.inc

DESCRIPTION = "WhereAmI uses local map tiles to provide a location display.  Thus, it requires no Internet connection.\
-However, the map does not display in the virtual bug because it reads the files from the bug's disk.-\
The tiles can be loaded directly from the web.\
Tiles are from OpenStreetMap.org.  The can also be loaded from disk in /home/root/tiles under the same structure as one the OSM server.\
-Tiles are US only.  If I have not rendered your state let me know and I will.-\
The OpenStreeMap has tiles for the entire world of some quality except the poles."
HOMEPAGE = "http://buglabs.net/applications/WhereAmI"

DEPENDS += "service-tracker com.buglabs.nmea com.buglabs.bug.module.lcd com.buglabs.common com.buglabs.bug.module.gps com.buglabs.osgi "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/534"

APIVERSION = ""
