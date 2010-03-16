DESCRIPTION = "library to provide userspace access to USB devices"
HOMEPAGE = "http://libusb.sf.net"
SECTION = "libs"
LICENSE = "LGPLv2.1"

SRC_URI = "${SOURCEFORGE_MIRROR}/libusb/libusb-${PV}.tar.bz2"
S = "${WORKDIR}/libusb-${PV}"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"
EXTRA_OECONF = "--disable-build-docs"
