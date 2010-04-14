PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
	file://desktop-name.patch;patch=1"

require gaim.inc

SRC_URI[md5sum] = "231f30505d7377bbdde0f350a4bcb838"
SRC_URI[sha256sum] = "63b05733e09d611c0f5645fe6c6315586916de80a42d7aeedb368737feff2cce"
