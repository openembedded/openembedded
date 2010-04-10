require xorg-app-common.inc

DESCRIPTION = "user preference utility for X"
LICENSE = "MIT"
DEPENDS += "libxext libxxf86misc libxfontcache libxmu libxp libxau"
PE = "1"

SRC_URI += "file://disable-xkb.patch;patch=1"

CFLAGS += "-D_GNU_SOURCE"
EXTRA_OECONF = "--disable-xkb"

SRC_URI[archive.md5sum] = "2f41fd983ba4d89419204854936025e2"
SRC_URI[archive.sha256sum] = "6c3e74bb36beab92b918f0db12198d2526675276c724558a1de71d7789d0bdad"
