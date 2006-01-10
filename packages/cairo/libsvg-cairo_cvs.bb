PV = "0.0+cvs${SRCDATE}"
SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "libsvg cairo"
DESCRIPTION = "SVG rendering library"
DEFAULT_PREFERENCE = "-1"
SRC_URI = "cvs://anoncvs:anoncvs@cvs.cairographics.org/cvs/cairo;module=libsvg-cairo"
S = "${WORKDIR}/libsvg-cairo"

inherit autotools pkgconfig 

do_stage () {
	autotools_stage_all
}
