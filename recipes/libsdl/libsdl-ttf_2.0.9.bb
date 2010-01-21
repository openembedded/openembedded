DESCRIPTION = "Simple DirectMedia Layer truetype font library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl freetype"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "http://www.libsdl.org/projects/SDL_ttf/release/SDL_ttf-${PV}.tar.gz"

S = "${WORKDIR}/SDL_ttf-${PV}"
EXTRA_OECONF += "SDL_CONFIG=${STAGING_BINDIR_CROSS}/sdl-config "

inherit autotools

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() { 
   oe_runconf
}
