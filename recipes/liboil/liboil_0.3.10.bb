DESCRIPTION = "Liboil is a library of simple functions that are optimized for various CPUs."
HOMEPAGE = "http://liboil.freedesktop.org/"
LICENSE = "various"

SRC_URI = "http://liboil.freedesktop.org/download/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "770f656bca8166dab33b322d5886a4bf"
SRC_URI[sha256sum] = "4587753a023550a066abe59a7e467c1af35b9f5e81bfb40a12463ad2df8f088c"
