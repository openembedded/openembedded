DESCRIPTION = "X mkfontdir app"
SECTION = "x11/apps"
LICENSE = "MIT-X"

S="${WORKDIR}/mkfontdir-${PV}"
SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/mkfontdir-${PV}.tar.bz2"

DEPENDS = "util-macros-native"
inherit native autotools pkgconfig
