DESCRIPTION = "Python libSDL Bindings"
SECTION = "devel/python"
HOMEPAGE = "http://www.pygame.org"
LICENSE = "LGPL"
DEPENDS = "libsdl-x11 libsdl-image libsdl-mixer libsdl-net libsdl-ttf python-numeric"
DEPENDS += "${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'smpeg', d)}"
RDEPENDS = "python-numeric"
SRCNAME = "pygame"
PR = "ml4"

SRC_URI = "http://www.pygame.org/ftp/${SRCNAME}-${PV}release.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "1c4cdc708d17c8250a2d78ef997222fc"
SRC_URI[archive.sha256sum] = "a26095472ae4be9631e0d5bfb9a52ac57a3a091e45757913128e4a473807d433"
S = "${WORKDIR}/${SRCNAME}-${PV}release"

inherit distutils

do_configure_prepend() {
	# Drop options to replace them later and drom pypm as we don't have portmidi/porttime
	sed '/^SDL =/d; /^SMPEG =/d; /^movie src/d; /^pypm src/d' Setup.in > Setup
	SDL="`sdl-config --cflags` `sdl-config --libs`"; echo "SDL=$SDL" >>Setup
	if [ '${ENTERPRISE_DISTRO}' != '1' ]; then
		SMPEG="`smpeg-config --cflags` `smpeg-config --libs`"; echo "SMPEG=$SMPEG" >>Setup
		echo "movie src/movie.c \$(SDL) \$(SMPEG) \$(DEBUG)" >>Setup
	fi
}
