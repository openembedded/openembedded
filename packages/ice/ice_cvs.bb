PV = "0.0cvs${CVSDATE}"
LICENSE= "MIT"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "x11"
DESCRIPTION = "X11 ICE library"
PR = "r1"

SRC_URI = "cvs://anoncvs:anoncvs@pdx.freedesktop.org/cvs/xlibs;module=ICE"
S = "${WORKDIR}/ICE"

inherit autotools pkgconfig 

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
