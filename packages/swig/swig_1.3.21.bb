SECTION = "unknown"
DESCRIPTION = "SWIG - Simplified Wrapper and Interface Generator"
LICENSE = "BSD"
#SRC_URI = "${SOURCEFORGE_MIRROR}/swig/swig-${PV}.tar.gz"
SRC_URI = "http://heanet.dl.sourceforge.net/sourceforge/swig/swig-1.3.21.tar.gz"
S = "${WORKDIR}/SWIG-${PV}"

inherit autotools

EXTRA_OECONF = "--with-python=${STAGING_BINDIR} --with-swiglibdir=${STAGING_DIR}/${BUILD_SYS}/swig"

do_configure() {
	oe_runconf
}
