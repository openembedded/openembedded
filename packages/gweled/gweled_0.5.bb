LICENSE = GPL
inherit autotools
SECTION = "x11/games"
DESCRIPTION = "Clone of Bejeweled for Gnome, modified for GPE."
DEPENDS = "gtk+ librsvg"
PRIORITY = "optional"

SRC_URI = "http://sebdelestaing.free.fr/gweled/Release/gweled-0.5.tar.gz \
	   file://de-gnome.patch;patch=1"

EXTRA_OECONF = " --disable-setgid --prefix=/usr"
