require xorg-app-common.inc

DESCRIPTION = "user preference utility for X"
LICENSE = "MIT"
DEPENDS += "libxext libxxf86misc libxfontcache libxmu libxp libxau"
PE = "1"

SRC_URI += "file://disable-xkb.patch;patch=1"

CFLAGS += "-D_GNU_SOURCE"
EXTRA_OECONF = "--disable-xkb"

SRC_URI[archive.md5sum] = "1b781a0802c7b8fb9619a6665607b3f0"
SRC_URI[archive.sha256sum] = "ce1e17c513a4499526e648a59c39ba01777c99c86093433cf392f27654b795c9"
