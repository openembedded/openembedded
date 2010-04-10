require xorg-font-common.inc

PACKAGE_ARCH = "${BASE_PACKAGE_ARCH}"

DESCRIPTION = "X font utils."

DEPENDS = "encodings"
RDEPENDS = "mkfontdir mkfontscale encodings"

PE = "1"
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "b81535f78fe05732931f02841e5ca37b"
SRC_URI[archive.sha256sum] = "048c23b17ea32ee3abb341f0b1105ad07517b2e78efe2e95a4a8218089600612"
