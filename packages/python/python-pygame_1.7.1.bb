DESCRIPTION = "Python libSDL Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
RDEPENDS = "python-numeric"
DEPENDS = "libsdl-x11 libsdl-image libsdl-mixer libsdl-net libsdl-ttf smpeg python-numeric"
SRCNAME = "pygame"
PR = "ml2"

SRC_URI = "http://www.pygame.org/ftp/${SRCNAME}-${PV}release.tar.gz \
           file://Setup"
S = "${WORKDIR}/${SRCNAME}-${PV}release"

inherit distutils

do_configure_prepend() {
	SDL="`sdl-config --cflags` `sdl-config --libs`"; echo "SDL=$SDL" >Setup
	cat ${WORKDIR}/Setup >>Setup
}
