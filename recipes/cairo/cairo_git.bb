#This is a development snapshot, so lets hint OE to use the releases
DEFAULT_PREFERENCE = "-1"

SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "pixman virtual/libx11 libsm libpng fontconfig libxrender"
DESCRIPTION = "Cairo graphics library"
LICENSE = "MPL LGPL"

PV = "1.5.3+git${SRCDATE}"

SRC_URI = "git://git.cairographics.org/git/cairo;protocol=git \
	  "
inherit autotools pkgconfig

S = "${WORKDIR}/git"

do_compile_append() {
	cd ${S}/perf ; oe_runmake
}

do_stage () {
 	autotools_stage_all
}
