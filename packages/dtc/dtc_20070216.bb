DESCRIPTION = "dtc tool"
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.jdl.com/pub/software/dtc-${PV}.tgz"

S = "${WORKDIR}/dtc"

inherit autotools

do_install() {
	install -m 0755 -d ${D}${bindir}	
	install -m 755 dtc ${D}${bindir}/dtc
}
