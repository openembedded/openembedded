DESCRIPTION = "Host side USB console utilities."
SECTION = "base"
DEPENDS += "virtual/libusb0"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEFAULT_PREFERENCE = "1"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/linux-usb/usbutils-${PV}.tar.gz \
	  "
S = "${WORKDIR}/usbutils-${PV}"

inherit autotools

EXTRA_OECONF = "--program-prefix="
sbindir = "/sbin"
bindir = "/bin"

FILES_${PN} += "${datadir}/usb*"

do_configure_prepend() {
	rm -rf ${S}/libusb
}

SRC_URI[md5sum] = "88978b4ad891f610620b1b8e5e0f43eb"
SRC_URI[sha256sum] = "2edc7cc98fd217f6980d8ba0b3792beed4695d4e8429a11c7237faab04ab47f4"
