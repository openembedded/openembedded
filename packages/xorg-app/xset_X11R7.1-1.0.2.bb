include xorg-app-common.inc

DESCRIPTION = "user preference utility for X"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
LICENSE = "MIT"

DEPENDS += " libxmu libxext libx11 libxxf86misc libxfontcache libxp"

CFLAGS += "-D_GNU_SOURCE"
EXTRA_OECONF = "--disable-xkb"

