DESCRIPTION = "This library provides weak aliases for pthread functions \
not provided in libc or otherwise available by default."
SECTION = "x11/libs"
LICENSE = "MIT-X"
HOMEPAGE = "http://xcb.freedesktop.org"
INC_PR = "r2"

BBCLASSEXTEND = "native nativesdk"

PARALLEL_MAKE = ""

SRC_URI = "http://xcb.freedesktop.org/dist/${BPN}-${PV}.tar.bz2"

inherit autotools pkgconfig
