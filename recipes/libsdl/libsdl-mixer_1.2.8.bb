DESCRIPTION = "Simple DirectMedia Layer mixer library."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl libmikmod libvorbis"
LICENSE = "LGPL"

PR = "r1"

SRC_URI = "http://www.libsdl.org/projects/SDL_mixer/release/SDL_mixer-${PV}.tar.gz"
S = "${WORKDIR}/SDL_mixer-${PV}"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

inherit autotools_stage

EXTRA_OECONF = "--disable-music-mp3"
# although we build smpeg... need to find out how
# to deal with optional dependencies
