DESCRIPTION = "Simple DirectMedia Layer networking library."
SECTION = "libs/network"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "virtual/libsdl"
LICENSE = "LGPL"

SRC_URI = "http://www.libsdl.org/projects/SDL_net/release/SDL_net-${PV}.tar.gz"
S = "${WORKDIR}/SDL_net-${PV}"

inherit autotools

do_stage() {
	oe_libinstall -so libSDL_net ${STAGING_LIBDIR}
	ln -sf libSDL_net.so ${STAGING_LIBDIR}/libSDL_net-1.2.so
	install -m 0644 SDL_net.h ${STAGING_INCDIR}/SDL/SDL_net.h
}

