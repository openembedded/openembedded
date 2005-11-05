DEPENDS = "ncurses"
DESCRIPTION = "A mixer for the terminal or X11, with mouse support."
SECTION = "console/multimedia"
LICENSE = "GPLV2"

SRC_URI = "http://jpj.net/~trevor/aumix/aumix-${PV}.tar.bz2 \
	   file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--without-gpm --without-sysmouse \
		--without-alsa --without-gtk \
		--without-gtk1"
