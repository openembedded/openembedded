DESCRIPTION = "Python libSDL Bindings"
SECTION = "devel/python"
HOMEPAGE = "http://www.pygame.org"
LICENSE = "LGPL"
DEPENDS = "libsdl-x11 libsdl-image libsdl-mixer libsdl-net libsdl-ttf python-numeric"
DEPENDS += "${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'smpeg', d)}"
SRCNAME = "pygame"
PR = "ml3"

SRC_URI = "\
  ftp://ftp.pygame.org/pub/pygame/${SRCNAME}-${PV}release.tar.gz \
  file://Setup"
S = "${WORKDIR}/${SRCNAME}-${PV}release"

inherit distutils

do_configure_prepend() {
	cat ${WORKDIR}/Setup >Setup
	SDL="`sdl-config --cflags` `sdl-config --libs`"; echo "SDL=$SDL" >>Setup
	if [ '${ENTERPRISE_DISTRO}' != '1' ]; then
		echo "movie src/movie.c \$(SDL) \$(SMPEG) \$(DEBUG)" >>Setup
	fi
}

do_stage() {
	distutils_stage_all
}

RDEPENDS = "python-numeric"
