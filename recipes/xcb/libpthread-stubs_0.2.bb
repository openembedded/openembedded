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

SRC_URI[md5sum] = "2ba9ce2d46da0a2a1090384ece3387ff"
SRC_URI[sha256sum] = "d4c47c24e5ec07e974a7ef8f55b2907dd7fa8de82e291a02b15f8c4a7028bf48"
