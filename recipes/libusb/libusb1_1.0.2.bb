DESCRIPTION = "library to provide userspace access to USB devices"
HOMEPAGE = "http://libusb.sf.net"
SECTION = "libs"
LICENSE = "LGPLv2.1"

SRC_URI = "${SOURCEFORGE_MIRROR}/libusb/libusb-${PV}.tar.bz2"
S = "${WORKDIR}/libusb-${PV}"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"
EXTRA_OECONF = "--disable-build-docs"

SRC_URI[md5sum] = "dc8865eaff167aabe78e5799762b8067"
SRC_URI[sha256sum] = "9f5737019f3e4c14f68a2f829deb690330e89b634d1337683e453b94137669f1"
