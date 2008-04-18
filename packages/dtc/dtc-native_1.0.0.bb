DESCRIPTION = "The Device Tree Compiler is a tool used to manipulate the Open-Firmware-like device tree used by PowerPC kernels."
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

DEFAULT_PREFERENCE = "1"

SRC_URI = "http://www.jdl.com/software/dtc-v${PV}.tgz"

S = "${WORKDIR}/dtc-v${PV}"

inherit autotools native

do_stage() {
	install -m 755 dtc ${STAGING_BINDIR}/dtc
}
