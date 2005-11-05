PV = "0.0cvs${CVSDATE}"
LICENSE = "MIT"

SECTION = "x11/libs"
DEPENDS = "x11 xext xxf86vmext"
DESCRIPTION = "Xxf86vm extension library."

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xxf86vm"
S = "${WORKDIR}/Xxf86vm"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
