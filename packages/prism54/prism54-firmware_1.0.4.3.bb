DESCRIPTION = "Firmware for the Prism54 driver"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://daemonizer.de/prism54/prism54-fw/fw-fullmac/${PV}.arm"

S = "${WORKDIR}/prism54.org"

do_install() {
	install -d ${D}${base_libdir}/firmware/
	install -m 0644 ${PV}.arm ${D}${base_libdir}/firmware/isl3890
}

FILES_${PN} = "/lib/firmware/"
