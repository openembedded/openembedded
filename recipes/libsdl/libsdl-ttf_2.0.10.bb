DESCRIPTION = "Simple DirectMedia Layer truetype font library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl freetype"
LICENSE = "LGPL"

# works only with libtool-2.4 and needs another libtool-update for 2.2.6b
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.libsdl.org/projects/SDL_ttf/release/SDL_ttf-${PV}.tar.gz \
           ${@['','file://libtool-update.patch'][bb.data.getVar('LIBTOOL_HAS_SYSROOT', d, 1) == 'yes']} \
          "

S = "${WORKDIR}/SDL_ttf-${PV}"
EXTRA_OECONF += "SDL_CONFIG=${STAGING_BINDIR_CROSS}/sdl-config "

inherit autotools

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI[md5sum] = "814e6e17e8879254208d23b3b7e0354b"
SRC_URI[sha256sum] = "7d38704bcc7c34029c2dcb73b2d4857e8ad76341c6e0faed279eb9f743c66c6a"
