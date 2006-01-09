PV = "0.0+cvs${SRCDATE}"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@debian.org>"
DEPENDS = "expat jpeg zlib libpng"
DESCRIPTION = "SVG parser library"
LICENSE = "LGPL"
SRC_URI = "cvs://anoncvs:anoncvs@cvs.cairographics.org/cvs/cairo;module=libsvg"
S = "${WORKDIR}/libsvg"
PR = "r2"

EXTRA_OECONF = "--with-expat"

inherit autotools pkgconfig 

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
