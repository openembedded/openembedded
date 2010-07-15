DESCRIPTION = "License for Marvel 8686 wifi chipsets"
LICENCE = "closed"

SRC_URI = "file://Marvell-Licence.txt"

RDEPENDS_${PN} += "marvell-license"

do_install() {

	install -d ${D}${base_libdir}/firmware
	install -m 0644 ${WORKDIR}/Marvell-Licence.txt ${D}${base_libdir}/firmware
}

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"
