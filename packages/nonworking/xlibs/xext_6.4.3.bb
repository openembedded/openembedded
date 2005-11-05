DESCRIPTION = "X Server Extension library"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "xproto x11 xextensions"

SRC_URI = "${XLIBS_MIRROR}/libXext-${PV}.tar.bz2"
S = "${WORKDIR}/libXext-${PV}"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
