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


SRC_URI[md5sum] = "6bd4662d1423810f3140d4da21b6d912"
SRC_URI[sha256sum] = "2ce7c84e62ff8117b9f205758bcce68ea603e08bc9d6936ded343735b8b77c53"
