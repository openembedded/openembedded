SECTION = "x11/libs"
LICENSE = "LGPL"
DEPENDS = "microwindows"
RDEPENDS = "microwindows"
SRC_URI = "ftp://ftp.microwindows.org/pub/microwindows/flnx/flnx-${PV}.tar.gz"
DESCRIPTION = "fltk library for microwindows."

inherit autotools

EXTRA_OECONF = "--with-microwin=${STAGING_LIBDIR}/.."

do_install () {
	oe_runmake "bindir=${D}${bindir}" \
		   "libdir=${D}${libdir}" \
		   "includedir=${D}${includedir}" install
}
