SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "x11 libpng fontconfig libxrender"
DESCRIPTION = "Cairo graphics library"
LICENSE = "MPL LGPL"
PR = "r0"

SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz"

inherit autotools pkgconfig 

do_stage () {
autotools_stage_all
}
