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

SRC_URI[md5sum] = "6dd5a85e4924689a35a5fb1cb3336156"
SRC_URI[sha256sum] = "b4248876798b43d0fae1931cf8ae249f4f67a87736f97183f035f34aab554653"
