DESCRIPTION = "Firmware for rt61 based USB wifi adaptors"
LICENSE = "unknown"

SRC_URI = "http://www.ralinktech.com.tw/data/RT61_Firmware_V${PV}.zip"

S = "${WORKDIR}/RT61_Firmware_V${PV}"

do_install() {
	install -d ${D}/${base_libdir}/firmware
	install -m 0644 *.bin ${D}/${base_libdir}/firmware/
}

FILES_${PN} = "${base_libdir}/firmware/"
PACKAGE_ARCH = "all"
