DESCRIPTION = "This software provides support for the Tag Image File Format (TIFF)"
LICENSE = ""
HOMEPAGE = "http://www.remotesensing.org/libtiff/"
DEPENDS = "zlib jpeg"
PR = "r1"

SRC_URI = "http://dl.maptools.org/dl/libtiff/old/tiff-${PV}.tar.gz"

inherit autotools

do_stage() {
	autotools_stage_includes
	install -d ${STAGING_LIBDIR}
	install -m 755 libtiff/.libs/libtiff.so.3.7.2 ${STAGING_LIBDIR}/libtiff.so
	install -m 755 ./libtiff/.libs/libtiffxx.so.3.7.2 ${STAGING_LIBDIR}/libtiffxx.so
}

PACKAGES =+ "tiffxx tiffxx-dbg tiffxx-dev tiff-utils tiff-utils-dbg"
FILES_tiffxx = "${libdir}/libtiffxx.so.*"
FILES_tiffxx-dev = "${libdir}/libtiffxx.so ${libdir}/libtiffxx.*a"
FILES_tiffxx-dbg = "${libdir}/.debug/libtiffxx.so*"
FILES_tiff-utils = "${bindir}/*"
FILES_tiff-utils-dbg = "${bindir}/.debug/"
