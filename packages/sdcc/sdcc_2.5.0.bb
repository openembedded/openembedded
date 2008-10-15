DESCRIPTION= "SDCC - Small Device C Compiler"
LICENSE = "GPL"
SECTION = "devel"
HOMEPAGE = "http://sdcc.sourceforge.net"
DEPENDS = "sdcc-native"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/sdcc/sdcc-${PV}.tar.gz \
           file://gcc4.patch;patch=1 \
           file://use-native-tools.patch;patch=1"
S = "${WORKDIR}/sdcc"

PARALLEL_MAKE = ""

inherit autotools

do_configure() {
	gnu-configize
	oe_runconf
}

