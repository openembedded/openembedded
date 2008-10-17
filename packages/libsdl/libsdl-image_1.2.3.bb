require libsdl-image.inc

FILE_PR = "r2"

SRC_URI += "\
  file://autotools.patch;patch=1 \
"

inherit autotools

do_stage() {
	autotools_stage_all
}

