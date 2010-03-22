DESCRIPTION = "Host side USB console utilities."
SECTION = "base"
DEPENDS += "virtual/libusb0"
LICENSE = "GPLv2"
PRIORITY = "optional"
PV = "0.71+cvs${SRCDATE}"
PR = "r4"

SRC_URI = "cvs://anonymous@linux-usb.cvs.sourceforge.net/cvsroot/linux-usb;module=usbutils"
S = "${WORKDIR}/usbutils"

inherit autotools

EXTRA_OECONF = "--program-prefix="
sbindir = "/sbin"
bindir = "/bin"

FILES_${PN} += "${datadir}/usb*"

do_configure_prepend() {
	rm -rf ${S}/libusb
}
