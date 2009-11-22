DESCRIPTION = "Firmware for Marvel 8686 gspi wifi chipset"
LICENCE = "closed"

SRC_URI = "file://${PV}.tar.gz \
           file://Marvell-Licence.txt"

S = "${WORKDIR}/${PV}/FwImage"

do_install() {

	install -d ${D}${base_libdir}/firmware
	install -m 0644 gspi8686.bin helper_gspi.bin ${D}${base_libdir}/firmware
	install -m 0644 ${WORKDIR}/Marvell-Licence.txt ${D}${base_libdir}/firmware
	ln -s helper_gspi.bin ${D}${base_libdir}/firmware/gspi8686_hlp.bin
}

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"
