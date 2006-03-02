SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@debian.org>"
# DEPENDS = "libx11 libpixman libpng fontconfig libxrender xcb glitz"
DEPENDS = "libx11 libpixman libpng fontconfig libxrender"
DESCRIPTION = "Cairo graphics library"
LICENSE = "MPL LGPL"
PR = "r0"

SRC_URI = "http://cairographics.org/snapshots/cairo-${PV}.tar.gz"

inherit autotools pkgconfig 

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
