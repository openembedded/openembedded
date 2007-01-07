LICENSE = "GPL"
SECTION = "console/multimedia"
DESCRIPTION = "A console MP3 player based on ncurses"
DEPENDS = "ncurses libogg libvorbis"

SRC_URI = "${SOURCEFORGE_MIRROR}/mp3blaster/mp3blaster-${PV}.tar.gz file://includedir.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-x=no --without-sidplay --with-oggvorbis --without-pth --without-mysql --without-nas"
