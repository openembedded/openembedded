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

SRC_URI[md5sum] = "a1f2206f1b4bd800e2461157faaa887f"
SRC_URI[sha256sum] = "6de182e93c946d432ed04362f0b93d889072438448dad20a21d4fcfa34cffa1d"
