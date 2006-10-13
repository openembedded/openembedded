DESCRIPTION = "glurp - frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/glurp.shtml"
LICENSE = "GPLv2"
SECTION = "gnome/multimedia"
DEPENDS = "gtk+ libglade"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/glurp/glurp-${PV}.tar.gz"

LDFLAGS += "-export-dynamic"

inherit autotools
