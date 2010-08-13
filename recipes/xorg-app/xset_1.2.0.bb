require xorg-app-common.inc
DESCRIPTION = "user preference utility for X"
LICENSE = "MIT"
DEPENDS += "libxext libxxf86misc libxfontcache libxmu libxp libxau"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://disable-xkb.patch"
SRC_URI[archive.md5sum] = "88ff2d390695366fa53e5d746fe86ad5"
SRC_URI[archive.sha256sum] = "f038dd98a1508ee9467946fa5d69cc6d758cd709f656a704d7a9c824eecc1bfd"

EXTRA_OECONF = "--disable-xkb"

CFLAGS += "-D_GNU_SOURCE"
