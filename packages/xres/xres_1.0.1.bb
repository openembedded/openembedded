SECTION = "x11/libs"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DEPENDS = "x11 xextensions xext resourceext"
DESCRIPTION = "X Resource usage library."
LICENSE = "X-MIT"
SRC_URI = "${XLIBS_MIRROR}/libXres-${PV}.tar.bz2"
S = "${WORKDIR}/libXres-${PV}"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
