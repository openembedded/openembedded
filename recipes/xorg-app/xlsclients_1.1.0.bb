require xorg-app-common.inc
DEPENDS += " xcb-util"
PE = "1"
PR = "${INC_PR}.0"

# missing file from source archive, fixed just after release in http://cgit.freedesktop.org/xorg/app/xlsclients/commit/?id=f30f41b8dc37e775279835c97f2bea83a513dc10
SRC_URI += "file://strnlen.h"
SRC_URI[archive.md5sum] = "550a0fee047c5043f2cbf190b41f8a1b"
SRC_URI[archive.sha256sum] = "f95b51f55399f46ce5f597a68ccd04a0d68c5770b517428201262bff09bcfa0c"

do_compile_prepend() {
  mv ${WORKDIR}/strnlen.h ${S}
}
