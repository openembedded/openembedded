require libsdl-image.inc

FILE_PR = "r2"

SRC_URI += "\
  file://autotools.patch;patch=1 \
"

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

inherit autotools

do_stage() {
	autotools_stage_all
}

