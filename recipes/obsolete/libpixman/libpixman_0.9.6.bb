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

