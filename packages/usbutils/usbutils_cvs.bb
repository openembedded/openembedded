DESCRIPTION = "Host side USB console utilities."
SECTION = "base"
DEPENDS += "libusb"
LICENSE = "GPL"
PRIORITY = "optional"
PV = "0.71+cvs${SRCDATE}"
PR = "r3"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/linux-usb;module=usbutils"
S = "${WORKDIR}/usbutils"

inherit autotools 

EXTRA_OECONF = "--program-prefix="
sbindir = "/sbin"
bindir = "/bin"

FILES_${PN} += "${datadir}/usb*"

do_configure_prepend() {
	rm -rf ${S}/libusb
}
