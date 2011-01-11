require xorg-app-common.inc
DESCRIPTION = "user preference utility for X"
LICENSE = "MIT"
DEPENDS += "libxext libxxf86misc libxfontcache libxmu libxp libxau"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://disable-xkb.patch"
SRC_URI[archive.md5sum] = "eeb0d02f69c76bd40470dede99b4bd49"
SRC_URI[archive.sha256sum] = "72c859c6030890a25cf828d0b2743454e50eadab30f6be8c17172fe97a554643"

EXTRA_OECONF = "--disable-xkb"

CFLAGS += "-D_GNU_SOURCE"
