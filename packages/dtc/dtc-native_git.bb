DESCRIPTION = "dtc tool"
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "git://www.jdl.com/software/dtc.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools native

do_stage() {
	install -m 755 dtc ${STAGING_BINDIR}/dtc
}
