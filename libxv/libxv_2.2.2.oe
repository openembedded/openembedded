LICENSE = GPL
SECTION = "x11/libs"
DEPENDS = "x11 xext"
DESCRIPTION = "X Video extension library."

SRC_URI = "${XLIBS_MIRROR}/libXv-${PV}.tar.bz2"
S = "${WORKDIR}/libXv-${PV}"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
