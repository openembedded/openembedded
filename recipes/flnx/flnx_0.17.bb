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

SRC_URI[md5sum] = "d44da0fc0fd495f580b9174d3beb6f7e"
SRC_URI[sha256sum] = "84fa995c461066ed39c587c834414ef1a320f605b6b6e1db2d10d12fa6a587db"
