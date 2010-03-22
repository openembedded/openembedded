DESCRIPTION = "libusb-0 compatibility library using libusb-1"
HOMEPAGE = "http://libusb.sf.net"
SECTION = "libs"
LICENSE = "LGPLv2.1"
PROVIDES = "virtual/libusb0"
PE = "1"
PR = "r0"

DEPENDS = "libusb1"

SRC_URI = "${SOURCEFORGE_MIRROR}/libusb/${P}.tar.bz2"
SRC_URI_append_nylon = " file://gcc-3-compatibility.patch;patch=1"

inherit autotools_stage binconfig lib_package

AUTOTOOLS_STAGE_PKGCONFIG = "1"
EXTRA_OECONF = "--disable-build-docs"
