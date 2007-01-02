DESCRIPTION = "Gesture recognition input method for X11"
LICENSE = "GPL"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 xft libxtst libxpm"
PR = "r2"

SRC_URI = "http://www.oesources.org/source/current/xstroke-0.6.tar.gz \
	file://auto-disable.patch;patch=1;pnum=0"

inherit autotools pkgconfig
