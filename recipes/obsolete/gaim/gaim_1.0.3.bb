PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
	file://desktop-name.patch;patch=1"

require gaim.inc

SRC_URI[md5sum] = "d0c40cbb57a80813fd495d3ffc6259df"
SRC_URI[sha256sum] = "dfcc3ed2a7fd919f8f5937bdaae9424cc12f0525c89cb1ffe661e7085abb62c7"
