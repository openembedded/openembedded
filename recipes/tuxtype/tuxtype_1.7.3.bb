DESCRIPTION = "Typing game"
HOMEPAGE = "http://tux4kids.alioth.debian.org/"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-image libsdl-ttf sdlpango"

# warning: when changing package version the download number (2767)
# must be changed as well
SRC_URI = "http://alioth.debian.org/frs/download.php/2767/tuxtype_w_fonts-1.7.3.tar.gz"

S = "${WORKDIR}/tuxtype_w_fonts-${PV}"

inherit autotools

FILES_${PN} = "/"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"
export MKDIR_P = "mkdir -p"

PARALLEL_MAKE = ""

SRC_URI[md5sum] = "9b76e5ebb3daf3d93545dc561229e2a5"
SRC_URI[sha256sum] = "1834524115d9b4ab49552dd078f56febd618deae88e064260744721e35fe60f6"
