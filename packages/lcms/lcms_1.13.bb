DESCRIPTION = "Little cms is a small-footprint, speed optimized color management engine."
SECTION = "libs"
LICENSE = "LGPL"
SRC_URI = "http://www.littlecms.com/lcms-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	oe_libinstall -a -so -C src/.libs/ liblcms ${STAGING_LIBDIR}
}
