SRCDATE = "20060814"
PV = "0.0+cvs${SRCDATE}"
LICENSE = "MIT-X"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libsvg-cairo xcursor"
DESCRIPTION = "SVG viewer"

SRC_URI = "cvs://anoncvs:anoncvs@cvs.cairographics.org/cvs/cairo;module=xsvg"
S = "${WORKDIR}/xsvg"

# FIXME: add xcursor
BROKEN = "1"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
