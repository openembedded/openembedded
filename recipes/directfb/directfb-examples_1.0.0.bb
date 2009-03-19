DESCRIPTION = "DirectFB extra providers"
DEPENDS = "directfb"
SECTION = "libs"
LICENSE = "GPL"

SRC_URI = " \
           http://www.directfb.org/downloads/Old/DirectFB-examples-${PV}.tar.gz \
          "
S = "${WORKDIR}/DirectFB-examples-${PV}"

inherit autotools

do_stage() {
	autotools_stage_all
}


