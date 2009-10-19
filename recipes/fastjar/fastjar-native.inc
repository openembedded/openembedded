DESCRIPTION = "jar replacement written in C."
HOMEPAGE = "http://savannah.nongnu.org/projects/fastjar/"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"

INC_PR = "r2"

DEPENDS = "zlib-native"

SRC_URI = "http://download.savannah.nongnu.org/releases/fastjar/fastjar-${PV}.tar.gz"

S = "${WORKDIR}/fastjar-${PV}"

inherit autotools native

do_configure () {
	gnu-configize || die "failure running gnu-configize"
	oe_runconf
}

do_make() {
	oe_runmake bin_PROGRAMS
}

do_stage() {
	oe_runmake install-binPROGRAMS
}
