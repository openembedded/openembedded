SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11"
DESCRIPTION = "Cairo support library"
LICENSE = "X11"
SRC_URI = "http://cairographics.org/snapshots/libpixman-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
