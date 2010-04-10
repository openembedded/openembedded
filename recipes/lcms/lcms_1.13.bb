DESCRIPTION = "Little cms is a small-footprint, speed optimized color management engine."
SECTION = "libs"
LICENSE = "LGPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/lcms/lcms-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	oe_libinstall -a -so -C src/.libs/ liblcms ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "902ea29818ab4f3c86225ec7d6b5d5b6"
SRC_URI[sha256sum] = "28e1648256cd18ccb3d0df149d3c33f94e7e2e0384b344f2792aa62309f825d6"
