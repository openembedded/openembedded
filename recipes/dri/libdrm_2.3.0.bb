SECTION = "x11/base"
LICENSE = "MIT"
SRC_URI = "http://dri.freedesktop.org/libdrm/libdrm-${PV}.tar.bz2"
PROVIDES = "drm"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "01a1e1ee0268a2403db42fa630036ab2"
SRC_URI[sha256sum] = "f8c711427fea50845811360c92f6350ff3dacb9533741470d54ae5d0a2f6848e"
