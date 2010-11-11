DESCRIPTION = "Host side USB console utilities."
SECTION = "base"
DEPENDS += "virtual/libusb0"
LICENSE = "GPLv2"
PRIORITY = "optional"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/linux-usb/usbutils-${PV}.tar.gz \
	  "
inherit autotools

EXTRA_OECONF = "--program-prefix="
sbindir = "${base_sbindir}"
bindir = "${base_bindir}"

PACKAGES =+ "${PN}-update"

FILES_${PN} += "${datadir}/usb*"
FILES_${PN}-update = "${sbindir}/update-usbids.sh"

do_configure_prepend() {
	rm -rf ${S}/libusb
}

do_install_append() {
	# The 0.86 Makefile.am installs both usb.ids and usb.ids.gz.
	if [ -f ${D}${datadir}/usb.ids.gz ]
	then
		rm -f ${D}${datadir}/usb.ids
	fi
}

SRC_URI[md5sum] = "34979f675d2bcb3e1b45012fa830a53f"
SRC_URI[sha256sum] = "b3b2bea6d2cd87660c8201a47071bf2a9889d8ed90c7203cc768b597799c12f4"
