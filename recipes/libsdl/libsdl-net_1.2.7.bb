DESCRIPTION = "Simple DirectMedia Layer networking library."
SECTION = "libs/network"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "http://www.libsdl.org/projects/SDL_net/release/SDL_net-${PV}.tar.gz \
	   file://libtool2.patch;patch=1 \
	  "

S = "${WORKDIR}/SDL_net-${PV}"

inherit autotools

EXTRA_OECONF += "SDL_CONFIG=${STAGING_BINDIR_CROSS}/sdl-config"

do_stage() {
	autotools_stage_all
}

