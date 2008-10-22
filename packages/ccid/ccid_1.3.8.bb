DESCRIPTION = "Generic USB CCID smart card reader driver"
HOMEPAGE = "http://pcsclite.alioth.debian.org/ccid.html"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "libusb pcsc-lite"
RDEPENDS = "pcsc-lite"

SRC_URI = "http://alioth.debian.org/download.php/2482/ccid-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--enable-udev"

do_install_append () {
	install -d "${D}/etc/udev/rules.d"
	install -m 644 "${S}/src/pcscd_ccid.rules" "${D}/etc/udev/rules.d/85-pcscd_ccid.rules"
}

FILES_${PN} += "${libdir}/pcsc/"
FILES_${PN}-dbg += "${libdir}/pcsc/drivers/*/*/*/.debug"
