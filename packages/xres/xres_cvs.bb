PV = "0.0cvs${CVSDATE}"
SECTION = "x11/libs"
MAINTAINER = "Greg Gilbert <greg@treke.net>"
DEPENDS = "x11 xextensions xext resourceext"
DESCRIPTION = "X Resource usage library."
LICENSE = "X-MIT"
SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=XRes"
S = "${WORKDIR}/XRes"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
