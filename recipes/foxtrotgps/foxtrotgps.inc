DESCRIPTION = "FoxtrotGPS is a map and GPS application using OpenStreetMap"
AUTHOR = "Joshua Judson Rosen <rozzin@geekspace.com>"
HOMEPAGE = "http://www.foxtrotgps.org/"
SECTION = "x11/applications"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "curl gtk+ gconf sqlite3 libexif"

SRC_URI = "http://www.foxtrotgps.org/releases/${P}.tar.gz"

inherit autotools pkgconfig

RRECOMMENDS_${PN} = "gpsd"
RRECOMMENDS_${PN}_shr = "fso-gpsd"
