DESCRIPTION = "Simple DirectMedia Layer truetype font library."
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "virtual/libsdl freetype"
LICENSE = "LGPL"

SRC_URI = "http://www.libsdl.org/projects/SDL_ttf/release/SDL_ttf-${PV}.tar.gz \
           file://new-freetype-includes.patch;patch=1"
S = "${WORKDIR}/SDL_ttf-${PV}"

inherit autotools

do_stage() {
	oe_libinstall -so libSDL_ttf ${STAGING_LIBDIR}
	ln -sf libSDL_ttf.so ${STAGING_LIBDIR}/libSDL_ttf-2.0.so
	install -m 0644 SDL_ttf.h ${STAGING_INCDIR}/SDL/SDL_ttf.h
}
