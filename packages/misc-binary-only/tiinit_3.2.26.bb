DESCRIPTION = "TI Bluetooth init bits."
SECTION = "base"
LICENSE = "Unknown"
PR = "r0"

SRC_URI = "http://sdgsystems.com/pub/ipaq/hx4700/src/TIInit_${PV}.bts"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/bluetooth/
	install -m 0644 TIInit_${PV}.bts ${D}${sysconfdir}/bluetooth/
}

PACKAGE_ARCH = "all"

