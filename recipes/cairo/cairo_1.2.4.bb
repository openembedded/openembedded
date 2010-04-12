SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 libpng fontconfig libxrender"
DESCRIPTION = "Cairo graphics library"
LICENSE = "MPL LGPL"
PR = "r2"

SRC_URI = "http://cairographics.org/releases/cairo-${PV}.tar.gz \
	   file://0001-Add-autoconf-macro-AX_C_FLOAT_WORDS_BIGENDIAN.diff;patch=1 \
	   file://0002-Change-_cairo_fixed_from_double-to-use-the-magic-number-technique.diff;patch=1 \
  	   "

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "1222b2bfdf113e2c92f66b3389659f2d"
SRC_URI[sha256sum] = "c1580ca951b2f57c4f8b34549997854bc48dbaf036ca1ca6c017c03db3504ddb"
