PV = "0.0+cvs${SRCDATE}"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11"
DESCRIPTION = "Cairo support library"
LICENSE = "X11"
SRC_URI = "cvs://anoncvs:anoncvs@cvs.cairographics.org/cvs/cairo;module=libpixman"
S = "${WORKDIR}/libpixman"

DEFAULT_PREFERENCE = "-1"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
