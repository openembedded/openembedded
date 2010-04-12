DESCRIPTION = "This library provides weak aliases for pthread functions \
not provided in libc or otherwise available by default."
SECTION = "x11/libs"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"

PARALLEL_MAKE = ""
#DEPENDS = "xcb-proto xproto libxau libxslt-native"
# DEPENDS += "xsltproc-native gperf-native"

SRC_URI = "http://xcb.freedesktop.org/dist/libpthread-stubs-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

SRC_URI[md5sum] = "774eabaf33440d534efe108ef9130a7d"
SRC_URI[sha256sum] = "004dae11e11598584939d66d26a5ab9b48d08a00ca2d00ae8d38ee3ac7a15d65"
