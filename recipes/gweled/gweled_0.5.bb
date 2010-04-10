LICENSE = "GPL"
inherit autotools
SECTION = "x11/games"
DESCRIPTION = "Clone of Bejeweled for Gnome, modified for GPE."
DEPENDS = "gtk+ librsvg"
PRIORITY = "optional"

SRC_URI = "http://sebdelestaing.free.fr/gweled/Release/gweled-0.5.tar.gz \
	   file://de-gnome.patch;patch=1"

EXTRA_OECONF = " --disable-setgid --prefix=/usr"

SRC_URI[md5sum] = "238f5ef66317bb24c3d4018a7d1e9ec3"
SRC_URI[sha256sum] = "d5baec578b22407e3fc78cc47393942f9704f1ab7b8d1c012577037d3421f90e"
