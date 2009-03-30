LICENSE = "GPL"
SECTION = "console/multimedia"
DESCRIPTION = "A console MP3 player based on ncurses"
DEPENDS = "ncurses libsidplay libogg libvorbis"

SRC_URI = "http://www.stack.nl/~brama/mp3blaster/src/mp3blaster-${PV}.tar.gz \
	   file://includedir.patch;patch=1"

inherit autotools

PARALLEL_MAKE=""

EXTRA_OECONF = "--with-x=no --with-sidplay --with-oggvorbis --without-pth --without-mysql --without-nas"
