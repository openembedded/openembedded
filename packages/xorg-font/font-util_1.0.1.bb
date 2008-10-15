require xorg-font-common.inc

PACKAGE_ARCH = "${BASE_PACKAGE_ARCH}"

DESCRIPTION = "X font utils."

DEPENDS = "encodings"
RDEPENDS = "mkfontdir mkfontscale encodings"

PR = "r1"
PE = "1"
