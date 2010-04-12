LICENSE = "GPL"
SECTION = "console/multimedia"
DESCRIPTION = "A console MP3 player based on ncurses"
DEPENDS = "ncurses libsidplay libogg libvorbis"

SRC_URI = "http://www.stack.nl/~brama/mp3blaster/src/mp3blaster-${PV}.tar.gz \
	   file://includedir.patch;patch=1"

inherit autotools

PARALLEL_MAKE=""

EXTRA_OECONF = "--with-x=no --with-sidplay --with-oggvorbis --without-pth --without-mysql --without-nas"

SRC_URI[md5sum] = "38beb6a5648cbca4ec87ee14b0982283"
SRC_URI[sha256sum] = "c1b110f2aa5ed8744f7f6eeabf24d6cd1cecc50f4b5473ec6ddf622935f360ee"
