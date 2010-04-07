DESCRIPTION = "Firmware for Texas Instruments WL1251 wifi chipset"
LICENCE = "closed"

SRC_URI = "file://*"
S = "${WORKDIR}"

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 README ${D}${base_libdir}/firmware/README.ti-wl1251
	for file in wl1251-fw.bin wl1251-nvs.bin
	do
		if test -e $file; then install -m 0644 $file ${D}${base_libdir}/firmware; fi
	done
}

# NOTE: This package is an empty stub, see firmware-ti-wl1251/README
ALLOW_EMPTY = "1"
PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"
