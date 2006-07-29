DESCRIPTION = "X mkfontscale app"
SECTION = "x11/apps"
LICENSE = "MIT-X"
S="${WORKDIR}/mkfontscale-${PV}"

DEPENDS = "virtual/libx11-native libfontenc-native"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/mkfontscale-${PV}.tar.bz2"

inherit native autotools pkgconfig
