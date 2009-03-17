DESCRIPTION = "X mkfontscale app"
SECTION = "x11/applications"
LICENSE = "MIT-X"
S="${WORKDIR}/mkfontscale-${PV}"

DEPENDS = "libx11-native libfontenc-native freetype-native"

SRC_URI = "${XORG_MIRROR}/individual/app/mkfontscale-${PV}.tar.bz2"

inherit native autotools pkgconfig
