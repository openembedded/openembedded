DESCRIPTION = "A fan control script for the Thecus n1200 or n2100"
SECTION = "console/network"
PR = "r2"
LICENSE = "GPL"
COMPATIBLE_MACHINE = "(n1200|n2100)"
RDEPENDS_${PN} = "hddtemp"

SRC_URI = "file://temper \
           file://init"

inherit update-rc.d

INITSCRIPT_NAME = "temper"
INITSCRIPT_PARAMS = "defaults"

do_install() {
	install -D -m 0755 ${WORKDIR}/temper ${D}/usr/sbin/temper
	install -D -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/temper
}
