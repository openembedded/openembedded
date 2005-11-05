PV = "0.0cvs${CVSDATE}"
LICENSE= "BSD-X"
SECTION = "x11/libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DESCRIPTION = "X Cursor library"
DEPENDS = "libxfixes"
PR = "r2"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xcursor"
S = "${WORKDIR}/Xcursor"
FILES_${PN} += "${libdir}/libXcursor.so"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR} \
	       mandir=${STAGING_DIR}/man
}
