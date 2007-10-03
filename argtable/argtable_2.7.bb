DESCRIPTION = "Argtable is an ANSI C library for parsing GNU style command line options."
SECTION = "libs"
LICENSE = "LGPL"
HOMEPAGE = "http://argtable.sourceforge.net/"

PR = "r0"

DEPENDS = "libtool-cross"

SRC_URI = "${SOURCEFORGE_MIRROR}/argtable/argtable2-6.tar.gz"

S = ${WORKDIR}/argtable2-6

inherit autotools

do_stage () {
	oe_libinstall -a -so libargtable2 ${STAGING_LIBDIR}
	install -m 0644 src/argtable2.h ${STAGING_INCDIR}
}


