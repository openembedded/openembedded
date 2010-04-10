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


SRC_URI[md5sum] = "8741490a25b98230973446400971bba9"
SRC_URI[sha256sum] = "c1f29cfd31c335a409bdc530c2e68661d20a1e3c2e5d64454470b6700a40681e"
