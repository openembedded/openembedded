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
