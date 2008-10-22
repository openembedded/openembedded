require libsdl-image.inc

PR = "r2"

SRC_URI += "\
  file://autotools.patch;patch=1 \
"

inherit autotools

do_stage() {
	autotools_stage_all
}

