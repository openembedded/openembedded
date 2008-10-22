PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
	file://desktop-name_1.4.0.patch;patch=1"

require gaim.inc

CFLAGS += "-D_GNU_SOURCE"

