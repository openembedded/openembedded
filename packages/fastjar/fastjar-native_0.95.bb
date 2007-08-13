DESCRIPTION = "jar replacement written in C."
HOMEPAGE = "http://savannah.nongnu.org/projects/fastjar/"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = "zlib-native"

SRC_URI = "http://download.savannah.nongnu.org/releases/fastjar/fastjar-${PV}.tar.gz"

S = "${WORKDIR}/fastjar-${PV}"

inherit autotools native

EXTRA_OECONF = "--with-system-zlib --with-fastjar"

do_configure () {
	gnu-configize || die "failure running gnu-configize"
	oe_runconf
}

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 755 fastjar ${STAGING_BINDIR}/fastjar
	install -m 755 grepjar ${STAGING_BINDIR}
}
