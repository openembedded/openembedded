SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "libsvg cairo"
DESCRIPTION = "SVG rendering library"

SRC_URI = "http://cairographics.org/snapshots/libsvg-cairo-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
