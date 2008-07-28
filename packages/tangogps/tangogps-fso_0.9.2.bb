LICENSE = "GPLv2"
SECTION = "x11/applications"
PRIORITY = "optional"
DESCRIPTION = "lightweight and fast mapping application"
DEPENDS = "curl gtk+ gconf gypsy dbus-glib"

inherit autotools

SRC_URI = "http://www.tangogps.org/downloads/tangogps-${PV}.tar.gz\
	file://0002-Get-GPS-data-via-the-gypsy-interface.patch;patch=1 \
	file://0003-Try-to-request-the-GPS-resource-from-ousaged.patch;patch=1"

S=${WORKDIR}/tangogps-${PV}
