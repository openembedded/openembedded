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

SRC_URI[md5sum] = "422fe94b86ca92fc8f3a9d7c1e14de0a"
SRC_URI[sha256sum] = "091f50b57dcd5e755be71ca8932892abccbbf8ae59c7131d5f06108033fec921"
