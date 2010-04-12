DESCRIPTION = "XCB: an X protocol C binding"
SECTION = "x11"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"
PR = "r0"

DEPENDS = "libxcb xcb-util"

SRC_URI = "http://xcb.freedesktop.org/dist/xcb-demo-0.1.tar.bz2"

inherit autotools pkgconfig

SRC_URI[md5sum] = "872ceecda2cfe3c4056716e414b6802d"
SRC_URI[sha256sum] = "20753bb59558dc00311a5a296fc6c4b3fcff04b86b2579fcb459c89b17d733a4"
