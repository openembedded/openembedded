
LICENSE = "MIT"
PV = "0.0cvs${CVSDATE}"

SECTION = "libs"
DEPENDS = "x11 xext"
DESCRIPTION = "X print extension library."

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=Xp"
S = "${WORKDIR}/Xp"

inherit autotools pkgconfig 

CFLAGS_append += " -I ${S}/include/X11/XprintUtil -I ${S}/include/X11/extensions"

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
