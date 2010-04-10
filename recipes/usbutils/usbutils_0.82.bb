DESCRIPTION = "Host side USB console utilities."
SECTION = "base"
DEPENDS += "virtual/libusb0"
LICENSE = "GPLv2"
PRIORITY = "optional"

SRC_URI = "${SOURCEFORGE_MIRROR}/linux-usb/usbutils-${PV}.tar.gz \
	  "
inherit autotools

EXTRA_OECONF = "--program-prefix="
sbindir = "/sbin"
bindir = "/bin"

FILES_${PN} += "${datadir}/usb*"

do_configure_prepend() {
	rm -rf ${S}/libusb
}

SRC_URI[md5sum] = "6e393cc7423b5d228fa3d34c21481ae4"
SRC_URI[sha256sum] = "9876b0e45a1bd3899222b916ab1d423e9efa3ad9374d55a6a301d5716f2d8a2f"
