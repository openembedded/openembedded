DESCRIPTION = "Liboil is a library of simple functions that are optimized for various CPUs."
HOMEPAGE = "http://liboil.freedesktop.org/"
LICENSE = "various"

SRC_URI = "http://liboil.freedesktop.org/download/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "5d139b1fb16f0e93f0c84290ad2aaff8"
SRC_URI[sha256sum] = "dd4d680ce95e586a1bbe767e1a7b25e1c53f842b8be6cf4e30e89cfa8232dd90"
