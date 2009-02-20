DESCRIPTION = "Math game"
HOMEPAGE = "http://tux4kids.alioth.debian.org/"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-image libsdl-ttf sdlpango"

# warning: when changing package version the download number (2733)
# must be changed as well
SRC_URI = "http://alioth.debian.org/frs/download.php/2733/tuxmath_w_fonts-1.7.1.tar.gz"

S = "${WORKDIR}/tuxmath_w_fonts-${PV}"

inherit autotools

FILES_${PN} = "/"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"
export MKDIR_P = "mkdir -p"

PARALLEL_MAKE = ""
