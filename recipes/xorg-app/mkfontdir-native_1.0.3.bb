DESCRIPTION = "X mkfontdir app"
SECTION = "x11/applications"
LICENSE = "MIT-X"
DEPENDS = "util-macros-native mkfontscale-native"
PR = "r1"
PE = "1"

S = "${WORKDIR}/mkfontdir-${PV}"
SRC_URI = "${XORG_MIRROR}/individual/app/mkfontdir-${PV}.tar.bz2"

inherit native autotools pkgconfig

SRC_URI[md5sum] = "4d0f89a23f77e22f1671a77bf0898955"
SRC_URI[sha256sum] = "2a786e03611a53c7f6263db446c0c9ef76e94bcf930b0b5867cc6a9c19653074"
