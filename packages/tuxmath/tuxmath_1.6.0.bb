DESCRIPTION = "Math game"
HOMEPAGE = "http://tux4kids.alioth.debian.org/"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libsdl libsdl-mixer libsdl-image libsdl-ttf"

SRC_URI = "http://alioth.debian.org/frs/download.php/2241/tuxmath_w_fonts-${PV}.tar.gz"
S = "${WORKDIR}/tuxmath_w_fonts-${PV}"

inherit autotools

PARALLEL_MAKE = ""

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"
export MKDIR_P = "mkdir -p"

FILES_${PN} = "/"
