DESCRIPTION = "Liboil is a library of simple functions that are optimized for various CPUs."
HOMEPAGE = "http://liboil.freedesktop.org/"
LICENSE = "various"
PR = "r4"

DEPENDS = "glib-2.0"

SRC_URI = "http://liboil.freedesktop.org/download/${P}.tar.gz \
	   file://autotools.patch;patch=1 \
	   file://arm-vfp.patch;patch=1 \
          "

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "11dd39b1ca13ce2e0618d4df8303f137"
SRC_URI[sha256sum] = "ae5e3b03a72dd4d12accbe7a6022e4e8570fa309defec9846341384d0a657fd4"
