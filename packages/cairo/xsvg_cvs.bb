PV = "0.0cvs${CVSDATE}"
LICENSE = "MIT-X"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libsvg-cairo xcursor"
DESCRIPTION = "SVG viewer"

SRC_URI = "cvs://anoncvs:anoncvs@cvs.cairographics.org/cvs/cairo;module=xsvg"
S = "${WORKDIR}/xsvg"

# FIXME: add xcursor
BROKEN = "1"

inherit autotools pkgconfig 

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
