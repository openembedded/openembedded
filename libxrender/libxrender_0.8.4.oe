SECTION = "libs"
DEPENDS = "renderext x11"
DESCRIPTION = "X Render extension library."
LICENSE = "BSD"
PR = "r1"

SRC_URI = "${XLIBS_MIRROR}/libXrender-${PV}.tar.bz2 \
	   file://autofoo.patch;patch=1"
S = "${WORKDIR}/libXrender-${PV}"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
