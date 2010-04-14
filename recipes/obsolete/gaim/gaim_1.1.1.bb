PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.bz2 \
	file://desktop-name.patch;patch=1"

require gaim.inc

SRC_URI[md5sum] = "5d554be5ccb2064a5b3d43117c7d6d4b"
SRC_URI[sha256sum] = "77fbf159af9a5382cf437e9c7f6e36f881aac628600b7fa947159db29fa9e91b"
