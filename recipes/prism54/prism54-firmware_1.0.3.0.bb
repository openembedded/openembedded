DESCRIPTION = "Firmware for the Prism54 driver"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "unknown"

SRC_URI = "http://daemonizer.de/prism54/prism54-fw/fw-fullmac/${PV}.arm"

S = "${WORKDIR}/prism54.org"

do_install() {
	install -d ${D}${base_libdir}/firmware/
	install -m 0644 ${PV}.arm ${D}${base_libdir}/firmware/isl3890
}

FILES_${PN} = "/lib/firmware/"

SRC_URI[md5sum] = "1f0a68fbe45963f76e525c9789f5609c"
SRC_URI[sha256sum] = "56524bd14b2bd3318824312f1272ed417de726110ef1d5e99c2a1171f65482fa"
