PV = "0.0cvs${CVSDATE}"
LICENSE = "MIT-X"
SECTION = "x11/libs"
DEPENDS = "xproto x11 xextensions"
DESCRIPTION = "X Input extension library."
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xi \
	   file://autofoo.patch;patch=1"
S = "${WORKDIR}/Xi"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR} \
	       mandir=${STAGING_DATADIR}/man
}
