require xorg-app-common.inc
DESCRIPTION = "The X Keyboard Extension essentially replaces the core protocol definition of keyboard."

S="${WORKDIR}/xkbcomp-${PV}"

DEPENDS = "libx11-native libxkbfile-native"

SRC_URI = "${XORG_MIRROR}/individual/app/xkbcomp-${PV}.tar.bz2"

inherit native

SRC_URI[md5sum] = "38c387bacdc01038c8ac280588792bcf"
SRC_URI[sha256sum] = "9775bcfd43d9ffa41e2865e5b2c933f419bf983d7a529b3103656c76fd82e663"
PR = "${INC_PR}.0"
