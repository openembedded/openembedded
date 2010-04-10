DESCRIPTION = "glurp - frontend for mpd"
HOMEPAGE = "http://www.musicpd.org/glurp.shtml"
SECTION = "x11/multimedia"
LICENSE = "GPLv2"
DEPENDS = "gtk+ libglade"

SRC_URI = "${SOURCEFORGE_MIRROR}/glurp/glurp-${PV}.tar.gz"

LDFLAGS += "-export-dynamic"

inherit autotools

SRC_URI[md5sum] = "cffb7c11906b71a54d4cd8e9d4bd043c"
SRC_URI[sha256sum] = "dd419074ed74f5685d1a9d55249544bb3527f7e4ee86facd480ca5b7f3618f30"
