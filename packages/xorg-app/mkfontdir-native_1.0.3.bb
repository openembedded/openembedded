DESCRIPTION = "X mkfontdir app"
SECTION = "x11/applications"
LICENSE = "MIT-X"
DEPENDS = "util-macros-native mkfontscale-native"
PR = "r1"
PE = "1"

S = "${WORKDIR}/mkfontdir-${PV}"
SRC_URI = "${XORG_MIRROR}/individual/app/mkfontdir-${PV}.tar.bz2"

inherit native autotools pkgconfig
