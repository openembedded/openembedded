DESCRIPTION = "The Device Tree Compiler is a tool used to manipulate the Open-Firmware-like device tree used by PowerPC kernels."
SECTION = "bootloader"
PRIORITY = "optional"
LICENSE = "GPL"

DEFAULT_PREFERENCE = "1"

SRC_URI = "http://www.jdl.com/software/dtc-v${PV}.tgz"

S = "${WORKDIR}/dtc-v${PV}"

inherit autotools

do_install() {
	install -m 0755 -d ${D}${bindir}	
	install -m 755 dtc ${D}${bindir}/dtc
}
