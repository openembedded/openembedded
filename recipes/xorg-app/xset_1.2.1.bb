require xorg-app-common.inc
DESCRIPTION = "user preference utility for X"
LICENSE = "MIT"
DEPENDS += "libxext libxxf86misc libxfontcache libxmu libxp libxau"
PE = "1"
PR = "${INC_PR}.0"

#SRC_URI += "file://disable-xkb.patch"
SRC_URI[archive.md5sum] = "4e0ce390394416c9e2c5cd4d7413ba87"
SRC_URI[archive.sha256sum] = "ec995f7d23109cfa6420ae87c38158f29a2a6f9d0b7df0a1be34e69e165292a1"

#EXTRA_OECONF = "--disable-xkb"

CFLAGS += "-D_GNU_SOURCE"
