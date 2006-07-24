DESCRIPTION = "X font utils."
SECTION = "x11/fonts"
LICENSE = "MIT-X"

S="${WORKDIR}/font-util-${PV}"

DEPENDS = "bdftopcf-native"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/font/font-util-${PV}.tar.gz"

inherit native autotools pkgconfig 
