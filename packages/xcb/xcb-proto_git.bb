DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "XCB: an X protocol C binding"
SECTION = "x11/libs"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"
MAINTAINER = "Philipp Zabel <philipp.zabel@gmail.com>"
PV = "0.9+git"
PR = "r0"

SRC_URI = "git://anongit.freedesktop.org/git/xcb;protocol=git"
S = "${WORKDIR}/git/xcb-proto"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
