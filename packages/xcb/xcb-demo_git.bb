DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "XCB: an X protocol C binding"
SECTION = "x11"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"
MAINTAINER = "Philipp Zabel <philipp.zabel@gmail.com>"
PV = "0.1+git"
PR = "r0"

DEPENDS = "libxcb xcb-util"

SRC_URI = "git://anongit.freedesktop.org/git/xcb;protocol=git"
S = "${WORKDIR}/git/xcb-demo"

inherit autotools pkgconfig
