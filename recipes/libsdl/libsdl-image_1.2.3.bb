require libsdl-image.inc

PR = "${INC_PR}.2"

SRC_URI += "\
  file://autotools.patch;patch=1 \
"

inherit autotools

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "d55826ffbd2bdc48b09cc64a9ed9e59e"
SRC_URI[sha256sum] = "2f710b94f547ec7e39844f7872e1fe8d6fe2a434c896cc8a54b5540854bb5a69"
