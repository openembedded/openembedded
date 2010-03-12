LICENSE = "GPL"
SECTION = "console/multimedia"
DESCRIPTION = "A console MP3 player based on ncurses"
DEPENDS = "ncurses libogg libvorbis"

SRC_URI = "${SOURCEFORGE_MIRROR}/mp3blaster/mp3blaster-${PV}.tar.gz;name=tarball \
           file://includedir.patch;patch=1"
SRC_URI[tarball.md5sum] = "edb3bb122553d2d544dfb084010311c6"
SRC_URI[tarball.sha256sum] = "129115742c77362cc3508eb7782702cfb44af2463a5453e8d19ea68abccedc29"



inherit autotools

EXTRA_OECONF = "--with-x=no --without-sidplay --with-oggvorbis --without-pth --without-mysql --without-nas"
