DESCRIPTION = "Quake 1"
SECTION = "x11/games"
PRIORITY = "optional"
DEPENDS = "libsdl-x11 libsdl-mixer libsdl-net zlib libxau"
LICENSE = "GPL"

SRC_URI = "http://www.libsdl.org/projects/quake/src/sdlquake-${PV}.tar.gz \
	   file://sdlquake-no-x86-asm.diff;patch=1 \
	   " 	

inherit autotools

# Fix up broken autofoo
do_configure_prepend() {
	touch INSTALL NEWS README AUTHORS ChangeLog
	echo "AM_PROG_AS" >> configure.in
}





SRC_URI[md5sum] = "6465dc6545970352dfa6305c36c2403d"
SRC_URI[sha256sum] = "097882b4613c87303dd068c41c95e77675da790cab63c7b440e70643d1741035"
