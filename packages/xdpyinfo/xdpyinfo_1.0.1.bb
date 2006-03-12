LICENSE = "MIT"
DEPENDS = "libx11 libxext libxtst"
DESCRIPTION = "X display information utility"
SECTION = "x11/base"

SRC_URI = "${XORG_MIRROR}/X11R7.0/src/app/xdpyinfo-1.0.1.tar.bz2 \
	   file://disable-xkb.patch;patch=1"

EXTRA_OECONF = "--disable-xkb"

inherit autotools pkgconfig 
