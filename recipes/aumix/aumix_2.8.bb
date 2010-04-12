DESCRIPTION = "A mixer for the terminal or X11, with mouse support."
SECTION = "console/multimedia"
LICENSE = "GPLV2"
DEPENDS = "ncurses"

SRC_URI = "http://jpj.net/~trevor/aumix/aumix-${PV}.tar.bz2 \
	   file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--without-gpm --without-sysmouse \
		--without-alsa --without-gtk \
		--without-gtk1"

SRC_URI[md5sum] = "dc3fc7209752207c23e7c94ab886b340"
SRC_URI[sha256sum] = "636eef7f400c2f3df489c0d2fa21507e88692113561e75a40a26c52bc422d7fc"
