DESCRIPTION = "library to provide userspace access to USB devices"
HOMEPAGE = "http://libusb.sf.net"
SECTION = "libs"
LICENSE = "LGPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/libusb/libusb-${PV}.tar.bz2"
S = "${WORKDIR}/libusb-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-build-docs"
