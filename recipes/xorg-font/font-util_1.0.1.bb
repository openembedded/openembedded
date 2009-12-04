require xorg-font-common.inc

PACKAGE_ARCH = "${BASE_PACKAGE_ARCH}"

DESCRIPTION = "X font utils."

DEPENDS = "encodings"
RDEPENDS = "mkfontdir mkfontscale encodings"

PE = "1"
PR = "${INC_PR}.1"
