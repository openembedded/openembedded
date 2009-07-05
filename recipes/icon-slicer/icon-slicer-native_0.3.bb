LICENSE = "MIT"

SRC_URI = "http://freedesktop.org/software/icon-slicer/releases/icon-slicer-${PV}.tar.gz"

inherit autotools native

DEPENDS = "gdk-pixbuf-csource-native popt-native"

S = "${WORKDIR}/icon-slicer-${PV}"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}



