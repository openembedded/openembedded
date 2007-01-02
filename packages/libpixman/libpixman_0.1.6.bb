SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11"
DESCRIPTION = "Cairo support library"
LICENSE = "X11"
SRC_URI = "http://cairographics.org/snapshots/libpixman-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
