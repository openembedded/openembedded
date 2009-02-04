DESCRIPTION = "SWIG - Simplified Wrapper and Interface Generator"
HOMEPAGE = "http://swig.sourceforge.net/"
LICENSE = "BSD"
SECTION = "devel"

SRC_URI = "${SOURCEFORGE_MIRROR}/swig/swig-${PV}.tar.gz"
S = "${WORKDIR}/swig-${PV}"

inherit autotools

EXTRA_OECONF = "--with-python=${STAGING_BINDIR_NATIVE} --with-swiglibdir=${STAGING_DIR_NATIVE}/swig"

do_configure() {
	oe_runconf
}

