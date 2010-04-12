LICENSE = "GPL"
SECTION = "console/multimedia"
DESCRIPTION = "A console MP3 player based on ncurses"
DEPENDS = "ncurses libogg libvorbis"

SRC_URI = "${SOURCEFORGE_MIRROR}/mp3blaster/mp3blaster-${PV}.tar.gz file://includedir.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-x=no --without-sidplay --with-oggvorbis --without-pth --without-mysql --without-nas"

SRC_URI[md5sum] = "0d892d7c99df175eb0efb2bc31086285"
SRC_URI[sha256sum] = "6dae6f0a018010fbf65985eb03684c3da8ef5024edfc80cace22162377c96f2d"
