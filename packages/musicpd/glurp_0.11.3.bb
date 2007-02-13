DESCRIPTION = "glurp - frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/glurp.shtml"
SECTION = "x11/multimedia"
LICENSE = "GPLv2"
DEPENDS = "gtk+ libglade"

SRC_URI = "${SOURCEFORGE_MIRROR}/glurp/glurp-${PV}.tar.gz"

LDFLAGS += "-export-dynamic"

inherit autotools
