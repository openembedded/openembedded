PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
	file://desktop-name.patch;patch=1"

require gaim.inc

CFLAGS += "-D_GNU_SOURCE"


SRC_URI[md5sum] = "9205321ac11fad271c90f2f0d7c5e7ce"
SRC_URI[sha256sum] = "58e3b0340cfc9e54e46f8d8835e5a02e31201c9ed8820bbb4cea36c59b9682aa"
