PV = "0.0+cvs${SRCDATE}"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@debian.org>"
# DEPENDS = "x11 libpixman libpng fontconfig libxrender xcb glitz"
DEPENDS = "x11 libpixman libpng fontconfig libxrender"
DESCRIPTION = "Cairo graphics library"
LICENSE = "MPL LGPL"
PR = "r2"
DEFAULT_PREFERENCE = "-1"
SRC_URI = "cvs://anoncvs:anoncvs@cvs.cairographics.org/cvs/cairo;module=cairo"
S = "${WORKDIR}/cairo"

inherit autotools pkgconfig 

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
