LICENSE = "GPL"
SECTION = "x11/libs"
DEPENDS = "x11 xext"
DESCRIPTION = "X Video extension library."

SRC_URI = "cvs://anoncvs@cvs.freedesktop.org/cvs/xlibs;module=Xv;date=20040918;method=pserver"
S = "${WORKDIR}/Xv"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR} \
	       mandir=${STAGING_DATADIR}/man
}
