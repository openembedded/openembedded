LICENSE = "GPL"
SECTION = "console/multimedia"
DESCRIPTION = "A console MP3 player based on ncurses"
DEPENDS = "ncurses libsidplay libogg libvorbis"

SRC_URI = "http://www.stack.nl/~brama/mp3blaster/src/mp3blaster-${PV}.tar.gz \
	   file://includedir.patch;patch=1"

inherit autotools

PARALLEL_MAKE=""

EXTRA_OECONF = "--with-x=no --with-sidplay --with-oggvorbis --without-pth --without-mysql --without-nas"

SRC_URI[md5sum] = "d01a36de2ebb5b4f7c407ae6cc7668b1"
SRC_URI[sha256sum] = "723b4674980e378efe07e097cf909894852054dd52d44f3d6f948d847c940815"
