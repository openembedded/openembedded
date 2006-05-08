DESCRIPTION = "user preference utility for X"
LICENSE = "MIT"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"

DEPENDS = "libx11 libxext xextproto libxmu"

CFLAGS += "-D_GNU_SOURCE"

SECTION = "x11/base"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/${PN}-X11R7.0-${PV}.tar.bz2 \
	   file://disable-xkb.patch;patch=1"
S = "${WORKDIR}/${PN}-X11R7.0-${PV}"

EXTRA_OECONF = "--disable-xkb"

inherit autotools pkgconfig 
