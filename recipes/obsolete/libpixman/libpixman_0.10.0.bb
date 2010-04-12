SECTION = "libs"
PRIORITY = "optional"
DESCRIPTION = "Low-level pixel manipulation library."
LICENSE = "X11"
SRC_URI = "http://cairographics.org/releases/pixman-${PV}.tar.gz"
S = "${WORKDIR}/pixman-${PV}"

inherit autotools pkgconfig

do_stage () {
 	autotools_stage_all
}


SRC_URI[md5sum] = "41804ac38025102dcc9891dfd4a3d105"
SRC_URI[sha256sum] = "48625f6b5ce130672942503c683d306d957ee40f59f8e59be6ca30a245ad47d0"
