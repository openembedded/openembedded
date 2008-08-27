DESCRIPTION = "Python libSDL Bindings"
SECTION = "devel/python"
HOMEPAGE = "http://www.pygame.org"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "libsdl-x11 libsdl-image libsdl-mixer libsdl-net libsdl-ttf smpeg python-numeric"
SRCNAME = "pygame"
PR = "ml1"

SRC_URI = "\
  ftp://ftp.pygame.org/pub/pygame/${SRCNAME}-${PV}release.tar.gz \
  file://Setup"
S = "${WORKDIR}/${SRCNAME}-${PV}release"

inherit distutils

do_configure_prepend() {
	cat ${WORKDIR}/Setup >Setup
	SDL="`sdl-config --cflags` `sdl-config --libs`"; echo "SDL=$SDL" >>Setup
}

do_stage() {
	distutils_stage_all
}

RDEPENDS = "python-numeric"
