PV = "0.0cvs${CVSDATE}"
SECTION = "x11/libs"
DEPENDS = "randrext x11 libxrender xext"
DESCRIPTION = "X Resize and Rotate extension library."
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xrandr \
	   file://autofoo.patch;patch=1"
S = "${WORKDIR}/Xrandr"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR} \
	       mandir=${STAGING_DATADIR}/man
}
