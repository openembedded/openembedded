SECTION = "x11/base"
LICENSE = "MIT"
SRC_URI = "http://dri.freedesktop.org/libdrm/libdrm-${PV}.tar.bz2"
PROVIDES = "drm"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "620fe7dd02c3236c3e9881a3a238173d"
SRC_URI[sha256sum] = "ddfd398383729707846e1f1689e9acb3bc672e4f255a632c8f0d0c55ddf8718c"
