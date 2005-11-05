DESCRIPTION = "Python libSDL Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "LGPL"
RDEPENDS = "python-core python-numeric"
DEPENDS = "virtual/libsdl libsdl-image libsdl-mixer libsdl-net libsdl-ttf smpeg python-numeric"
SRCNAME = "pygame"

SRC_URI = "http://www.pygame.org/ftp/${SRCNAME}-${PV}.tar.gz \
           file://qpe.patch;patch=1 \
           file://Setup"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_configure_prepend() {
	SDL="`sdl-config --cflags` `sdl-config --libs`"; echo "SDL=$SDL" >Setup
        cat ${WORKDIR}/Setup >>Setup
}
