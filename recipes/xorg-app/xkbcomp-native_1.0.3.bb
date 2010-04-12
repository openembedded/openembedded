DESCRIPTION = "The X Keyboard Extension essentially replaces the core protocol definition of keyboard."

SECTION = "x11/applications"
LICENSE = "MIT-X"
S="${WORKDIR}/xkbcomp-${PV}"

DEPENDS = "libx11-native libxkbfile-native"

SRC_URI = "${XORG_MIRROR}/individual/app/xkbcomp-${PV}.tar.bz2"

inherit native autotools pkgconfig

SRC_URI[md5sum] = "2fbcae1323c266edf5b6c61751f2e343"
SRC_URI[sha256sum] = "0635bae5dae3c933ebba997475ae14fa213aee1f2ea8aaff2ca76c50f8aec716"
