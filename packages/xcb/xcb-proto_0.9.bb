DESCRIPTION = "XCB: an X protocol C binding"
SECTION = "x11/libs"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"
MAINTAINER = "Philipp Zabel <philipp.zabel@gmail.com>"
PR = "r0"

SRC_URI = "http://xcb.freedesktop.org/dist/xcb-proto-0.9.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
