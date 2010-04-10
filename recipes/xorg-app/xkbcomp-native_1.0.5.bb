DESCRIPTION = "The X Keyboard Extension essentially replaces the core protocol definition of keyboard."

SECTION = "x11/applications"
LICENSE = "MIT-X"
S="${WORKDIR}/xkbcomp-${PV}"

DEPENDS = "libx11-native libxkbfile-native"

SRC_URI = "${XORG_MIRROR}/individual/app/xkbcomp-${PV}.tar.bz2"

inherit native autotools pkgconfig

SRC_URI[md5sum] = "6cc96c3e4ed5d9802fe717beac008f19"
SRC_URI[sha256sum] = "204403e0388e83127212109310037d17f56c3c3fd3c96d7dcaa0df99684f00c1"
