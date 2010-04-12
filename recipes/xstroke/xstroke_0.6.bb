DESCRIPTION = "Gesture recognition input method for X11"
LICENSE = "GPL"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 xft libxtst libxpm"
PR = "r2"

SRC_URI = "http://www.oesources.org/source/current/xstroke-0.6.tar.gz \
	file://auto-disable.patch;patch=1;pnum=0"

inherit autotools pkgconfig

SRC_URI[md5sum] = "bdfa8834bc2e78c4874d558025d944e2"
SRC_URI[sha256sum] = "a3a947e9982fe1feef235fcbcf41b01b5f86ebf46d106fa719801cf061f6bb00"
