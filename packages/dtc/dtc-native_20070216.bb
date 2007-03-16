DESCRIPTION = "dtc tool"
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://www.jdl.com/pub/software/dtc-${PV}.tgz"

S = "${WORKDIR}/dtc"

inherit autotools native

do_stage() {
	install -m 755 dtc ${STAGING_BINDIR}/dtc
}
