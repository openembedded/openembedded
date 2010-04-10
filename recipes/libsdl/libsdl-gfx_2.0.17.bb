DESCRIPTION = "Simple DirectMedia Layer graphic primitives library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "zlib libpng jpeg virtual/libsdl"
LICENSE = "LGPL"

SRC_URI = "http://www.ferzkopp.net/~aschiffler/Software/SDL_gfx-2.0/SDL_gfx-${PV}.tar.gz"
S = "${WORKDIR}/SDL_gfx-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-mmx"
TARGET_CC_ARCH += "${LDFLAGS}"

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "a7ab98ad530fdc59a23f7dff502db8d3"
SRC_URI[sha256sum] = "d08d8477ff1c6639bc7193b76a415f996c98604600e9fa4e718fd4e9283f83f4"
