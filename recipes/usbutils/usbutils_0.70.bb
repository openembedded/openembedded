DESCRIPTION = "Host side USB console utilities."
SECTION = "base"
DEPENDS += "virtual/libusb0"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEFAULT_PREFERENCE = "1"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/linux-usb/usbutils-${PV}.tar.gz"
S = "${WORKDIR}/usbutils-${PV}"

inherit autotools

EXTRA_OECONF = "--program-prefix="
sbindir = "/sbin"
bindir = "/bin"

FILES_${PN} += "${datadir}/usb*"

do_configure_prepend() {
	rm -rf ${S}/libusb
}

SRC_URI[md5sum] = "05276dc307a0297904bc892e9998bf59"
SRC_URI[sha256sum] = "98d29c0c013debc32f1a17fd66f5e9248025959b07d13f1faba91aa5a1a9ba6b"
