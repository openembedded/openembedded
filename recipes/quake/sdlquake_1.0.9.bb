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




