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

TARGET_CC_ARCH += "${LDFLAGS}"

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "29d12d1b883bf834c291c93f52ba8dc5"
SRC_URI[sha256sum] = "7e2e7b46088a7b9594b255b58123598d49c5c3d11bcc3c9a8f80969cd9caa6c5"
