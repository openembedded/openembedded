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


SRC_URI[md5sum] = "c572e7842fe36348f5b2972c1025a75a"
SRC_URI[sha256sum] = "138d2e59569f76f1a5d35bd5d85e7006eeebc4f48cd3dac902e2824ed50c3d80"
