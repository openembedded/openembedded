PV = "0.0cvs${CVSDATE}"
SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@debian.org>"
DEPENDS = "libsvg cairo"
DESCRIPTION = "SVG rendering library"
DEFAULT_PREFERENCE = "-1"
SRC_URI = "cvs://anoncvs:anoncvs@cvs.cairographics.org/cvs/cairo;module=libsvg-cairo"
S = "${WORKDIR}/libsvg-cairo"

inherit autotools pkgconfig 

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
