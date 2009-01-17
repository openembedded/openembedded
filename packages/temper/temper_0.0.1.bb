DESCRIPTION = "A fan control script for the Thecus n1200 or n2100"
SECTION = "console/network"
PR = "r0"
LICENSE = "GPL"
COMPATIBLE_MACHINE = "(n1200|n2100)"
RDEPENDS = "hddtemp"

SRC_URI = "file://temper"

do_install() {
	install -d ${D}/usr/sbin
	install -D -m 0755 ${WORKDIR}/temper ${D}/usr/sbin/temper
}
