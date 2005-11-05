DESCRIPTION = "Firmware for the Prism54 driver"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "unknown"

SRC_URI = "http://prism54.org/~mcgrof/firmware/${PV}.arm"

S = "${WORKDIR}/prism54.org"

do_install() {
	install -d ${D}${base_libdir}/firmware/
	install -m 0644 ${PV}.arm ${D}${base_libdir}/firmware/isl3890
}

FILES_${PN} = "/lib/firmware/"
