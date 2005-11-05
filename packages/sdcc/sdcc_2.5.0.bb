DESCRIPTION= "SDCC - Small Device C Compiler"
LICENSE = "GPL"
SECTION = "devel"
HOMEPAGE = "http://sdcc.sourceforge.net"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/sdcc/sdcc-${PV}.tar.gz"
S = "${WORKDIR}/sdcc"

PARALLEL_MAKE = ""

inherit autotools

do_configure() {
	gnu-configize
	oe_runconf
}

