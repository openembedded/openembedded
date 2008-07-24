DESCRIPTION = "Simple DirectMedia Layer image library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib libpng jpeg virtual/libsdl"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "http://www.libsdl.org/projects/SDL_image/release/SDL_image-${PV}.tar.gz \
	   file://autotools.patch;patch=1 \
	  "

S = "${WORKDIR}/SDL_image-${PV}"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

inherit autotools

do_stage() {
	autotools_stage_all
}

