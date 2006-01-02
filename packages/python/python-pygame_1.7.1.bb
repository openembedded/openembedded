DESCRIPTION = "Python libSDL Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "LGPL"
RDEPENDS = "python-core python-numeric libsdl-x11"
DEPENDS = "virtual/libsdl libsdl-image libsdl-mixer libsdl-net libsdl-ttf smpeg python-numeric"
SRCNAME = "pygame"
PR = "ml1"

SRC_URI = "http://www.pygame.org/ftp/${SRCNAME}-${PV}release.tar.gz \
           file://Setup"
S = "${WORKDIR}/${SRCNAME}-${PV}release"

inherit distutils

do_configure_prepend() {
	SDL="`sdl-config --cflags` `sdl-config --libs`"; echo "SDL=$SDL" >Setup
        cat ${WORKDIR}/Setup >>Setup
}
