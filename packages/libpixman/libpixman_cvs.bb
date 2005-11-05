PV = "0.0cvs${CVSDATE}"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@debian.org>"
DEPENDS = "x11"
DESCRIPTION = "Cairo support library"
LICENSE = "X11"
SRC_URI = "cvs://anoncvs:anoncvs@cvs.cairographics.org/cvs/cairo;module=libpixman"
S = "${WORKDIR}/libpixman"

DEFAULT_PREFERENCE = "-1"

inherit autotools pkgconfig 

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
