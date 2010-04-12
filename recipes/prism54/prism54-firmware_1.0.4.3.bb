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

SRC_URI[md5sum] = "8bd4310971772a486b9784c77f8a6df9"
SRC_URI[sha256sum] = "dce24156c57234dba131429fbe8cd1de8ba818c9481ddc33cf7e5af9d57a737c"
