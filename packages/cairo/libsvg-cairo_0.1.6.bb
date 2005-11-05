SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@debian.org>"
DEPENDS = "libsvg cairo"
DESCRIPTION = "SVG rendering library"

SRC_URI = "http://cairographics.org/snapshots/libsvg-cairo-${PV}.tar.gz"

inherit autotools pkgconfig 

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
