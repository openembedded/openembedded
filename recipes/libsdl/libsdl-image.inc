DESCRIPTION = "Simple DirectMedia Layer image library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib libpng jpeg virtual/libsdl"
LICENSE = "LGPL"

INC_PR = "r5"

SRC_URI = "http://www.libsdl.org/projects/SDL_image/release/SDL_image-${PV}.tar.gz"

S = "${WORKDIR}/SDL_image-${PV}"

inherit autotools

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

