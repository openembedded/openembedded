SECTION = "unknown"
DEPENDS = "opensp"
RDEPENDS = "sgml-common"
DESCRIPTION = "OpenJade is a suite of tools for validating, \
processing, and applying DSSSL (Document Style Semantics and \
Specification Language) stylesheets to SGML and XML documents."
LICENSE = "BSD"
SRC_URI = "${SOURCEFORGE_MIRROR}/openjade/openjade-${PV}.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--enable-spincludedir=${STAGING_INCDIR}/OpenSP \
                --enable-splibdir=${STAGING_LIBDIR}"

acpaths = "-I ${S}/config"

# Trailing whitespace is important. Otherwise compiler arguments will be messed
# up, resulting in a fail in do_configure.
CFLAGS_prepend = "-I${S}/include "

do_configure_prepend () {
        mv config/configure.in .
}

do_stage () {
	oe_libinstall -a -so -C style libostyle ${STAGING_LIBDIR}
	oe_libinstall -a -so -C spgrove libospgrove ${STAGING_LIBDIR}
	oe_libinstall -a -so -C grove libogrove ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "7df692e3186109cc00db6825b777201e"
SRC_URI[sha256sum] = "1d2d7996cc94f9b87d0c51cf0e028070ac177c4123ecbfd7ac1cb8d0b7d322d1"
