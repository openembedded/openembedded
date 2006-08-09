DESCRIPTION = "SWIG - Simplified Wrapper and Interface Generator"
SECTION = "unknown"
HOMEPAGE = "http://swig.sourceforge.net/"
LICENSE = "BSD"
PV = "0.0cvs${CVSDATE}"
PR = "r0"

SRC_URI = "cvs://anonymous:@cvs.sourceforge.net/cvsroot/swig;module=SWIG"
S = "${WORKDIR}/SWIG"

inherit autotools

EXTRA_OECONF = "--with-python=${STAGING_BINDIR} --with-swiglibdir=${STAGING_DIR}/${BUILD_SYS}/swig"

do_configure_prepend() {
	./autogen.sh
}

do_configure() {
	oe_runconf
}

