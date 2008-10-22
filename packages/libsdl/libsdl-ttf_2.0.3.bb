DESCRIPTION = "Simple DirectMedia Layer truetype font library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl freetype"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "http://www.libsdl.org/projects/SDL_ttf/release/SDL_ttf-${PV}.tar.gz \
           file://new-freetype-includes.patch;patch=1"
S = "${WORKDIR}/SDL_ttf-${PV}"

inherit autotools

do_stage() {
	autotools_stage_all
}
