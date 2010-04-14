PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
	file://desktop-name.patch;patch=1"

require gaim.inc

CFLAGS += "-D_GNU_SOURCE"


SRC_URI[md5sum] = "d4bb61059214cfdbc75f85fe185b0e01"
SRC_URI[sha256sum] = "39781205840b8b38fbb3ef86accc885a4267958b8aeea396806d0521dfd969e5"
