LICENSE = GPL
PV = "0.0cvs${CVSDATE}"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "x11"
DESCRIPTION = "X11 keyboard library"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=xkbfile"
S = "${WORKDIR}/xkbfile"

inherit autotools pkgconfig 

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}
