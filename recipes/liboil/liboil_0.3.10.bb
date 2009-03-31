DESCRIPTION = "Liboil is a library of simple functions that are optimized for various CPUs."
HOMEPAGE = "http://liboil.freedesktop.org/"
LICENSE = "various"

SRC_URI = "http://liboil.freedesktop.org/download/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
