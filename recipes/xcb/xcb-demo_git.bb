DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "XCB: an X protocol C binding"
SECTION = "x11"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"
SRCREV = "7cf9a16bfa0653d83726754599b5b2f27fcb0b2c"
PV = "0.1+git"
PR = "r0"

DEPENDS = "libxcb xcb-util"

SRC_URI = "git://anongit.freedesktop.org/xcb/demo;protocol=git"
S = "${WORKDIR}/git"

inherit autotools pkgconfig
