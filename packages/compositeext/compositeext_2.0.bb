SECTION = "libs"
LICENSE= "BSD-X"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DEPENDS = "xextensions fixesext"
DESCRIPTION = "X Composite extension headers and specification"

SRC_URI = "${XLIBS_MIRROR}/compositeext-${PV}.tar.bz2"

inherit autotools pkgconfig

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
