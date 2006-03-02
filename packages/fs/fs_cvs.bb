PV = "0.0+cvs${SRCDATE}"
LICENSE = "BSD-X"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libxfont xtrans"

SRC_URI = "${FREEDESKTOP_CVS}/xlibs;module=FS"
S = "${WORKDIR}/FS"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
