DESCRIPTION = "Simple DirectMedia Layer mixer library."
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "virtual/libsdl"
LICENSE = "LGPL"

SRC_URI = "http://www.libsdl.org/projects/SDL_mixer/release/SDL_mixer-${PV}.tar.gz"
S = "${WORKDIR}/SDL_mixer-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-music-mp3"
# although we build smpeg... need to find out how
# to deal with optional dependencies

do_stage() {
	oe_libinstall -so libSDL_mixer ${STAGING_LIBDIR}
	ln -sf libSDL_mixer.so ${STAGING_LIBDIR}/libSDL_mixer-1.2.so
	install -m 0644 SDL_mixer.h ${STAGING_INCDIR}/SDL/SDL_mixer.h
}

