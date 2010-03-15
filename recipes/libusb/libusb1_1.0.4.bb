DESCRIPTION = "library to provide userspace access to USB devices"
HOMEPAGE = "http://libusb.sf.net"
SECTION = "libs"
LICENSE = "LGPLv2.1"

PR = "r1"

SRC_URI = " \
           ${SOURCEFORGE_MIRROR}/libusb/libusb-${PV}.tar.bz2 \
           file://libusb-shortok.patch;patch=1 \
          "
S = "${WORKDIR}/libusb-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-build-docs"
