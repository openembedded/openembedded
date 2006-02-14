SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "expat jpeg zlib libpng"
DESCRIPTION = "SVG parser library"
PR = "r0"

SRC_URI = "http://cairographics.org/snapshots/libsvg-${PV}.tar.gz \
           file://gcc4_and_expat.patch;patch=1"

EXTRA_OECONF = "--with-expat"

inherit autotools pkgconfig 

do_stage () {
	autotools_stage_all
}
