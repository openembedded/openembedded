DESCRIPTION = "Little cms is a small-footprint, speed optimized color management engine."
SECTION = "libs"
LICENSE = "LGPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/lcms/lcms-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
