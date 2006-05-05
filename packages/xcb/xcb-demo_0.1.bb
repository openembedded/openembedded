DESCRIPTION = "XCB: an X protocol C binding"
SECTION = "x11"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"
MAINTAINER = "Philipp Zabel <philipp.zabel@gmail.com>"
PR = "r0"

DEPENDS = "libxcb xcb-util"

SRC_URI = "http://xcb.freedesktop.org/dist/xcb-demo-0.1.tar.bz2"

inherit autotools pkgconfig
