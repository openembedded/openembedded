DESCRIPTION = "Simple DirectMedia Layer graphic primitives library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib libpng jpeg virtual/libsdl"
LICENSE = "LGPL"

SRC_URI = "http://www.ferzkopp.net/~aschiffler/Software/SDL_gfx-2.0/SDL_gfx-${PV}.tar.gz"
S = "${WORKDIR}/SDL_gfx-${PV}"

inherit autotools

TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OECONF = "--disable-mmx"

do_stage() {
	oe_libinstall -so libSDL_gfx ${STAGING_LIBDIR}
	install -m 0644 *.h ${STAGING_INCDIR}/SDL/
}


SRC_URI[md5sum] = "10f6432ede2b239796f2924bdc7224b4"
SRC_URI[sha256sum] = "6a3ef9f5556a3d75832b2b9138bdf3551dc59994d2849307f88a9dcd9732d16c"
