PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
	file://desktop-name_1.4.0.patch;patch=1"

require gaim.inc

CFLAGS += "-D_GNU_SOURCE"


SRC_URI[md5sum] = "d7717cb771e556012ecd5b7f3bdb02ba"
SRC_URI[sha256sum] = "9f44792ea9df64e0a1df9c9efe3baefb6150e4c93b8b414f0a2b398e3f8eb32c"
