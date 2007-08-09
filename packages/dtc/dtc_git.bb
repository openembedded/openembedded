DESCRIPTION = "dtc tool"
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "git://www.jdl.com/software/dtc.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools

do_install() {
	install -m 0755 -d ${D}${bindir}	
	install -m 755 dtc ${D}${bindir}/dtc
}
