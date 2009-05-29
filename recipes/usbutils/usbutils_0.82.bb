DESCRIPTION = "Host side USB console utilities."
SECTION = "base"
DEPENDS += "libusb-compat"
LICENSE = "GPL"
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
