DESCRIPTION = "Firmware for Marvel 8686 gspi wifi chipset"
LICENCE = "closed"

SRC_URI = "file://${PV}.tar.gz"

PR = "r1"

RDEPENDS_${PN} += "marvell-license"

S = "${WORKDIR}/${PV}/FwImage"

do_install() {

	install -d ${D}${base_libdir}/firmware
	install -m 0644 sd8686.bin sd8686_helper.bin ${D}${base_libdir}/firmware
}

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"
