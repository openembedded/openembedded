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

SRC_URI[md5sum] = "34979f675d2bcb3e1b45012fa830a53f"
SRC_URI[sha256sum] = "b3b2bea6d2cd87660c8201a47071bf2a9889d8ed90c7203cc768b597799c12f4"
