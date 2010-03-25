DESCRIPTION = "This software provides support for the Tag Image File Format (TIFF)"
LICENSE = "${PN}"
HOMEPAGE = "http://www.remotesensing.org/libtiff/"
DEPENDS = "zlib jpeg lzo"
PV = "3.9.2+4.0.0beta5"

PR = "r2"

SRC_URI = "ftp://ftp.remotesensing.org/pub/libtiff/tiff-4.0.0beta5.tar.gz;name=tiff400beta5targz"
SRC_URI[tiff400beta5targz.md5sum] = "a0a83604e38a299fae9f0b1a39c04870"
SRC_URI[tiff400beta5targz.sha256sum] = "64b61567782643a841e33a8d031d0d6a9b3e436108829e2e947183f8dcdc6ec7"

S = "${WORKDIR}/tiff-4.0.0beta5"

inherit autotools

# requires a too recent, non-default autoconf
do_configure() {
	gnu-configize
	oe_runconf
}

PACKAGES =+ "tiffxx tiffxx-dbg tiffxx-dev tiff-utils tiff-utils-dbg"
FILES_tiffxx = "${libdir}/libtiffxx.so.*"
FILES_tiffxx-dev = "${libdir}/libtiffxx.so ${libdir}/libtiffxx.*a"
FILES_tiffxx-dbg += "${libdir}/.debug/libtiffxx.so*"
FILES_tiff-utils = "${bindir}/*"
FILES_tiff-utils-dbg += "${bindir}/.debug/"

BBCLASSEXTEND = "native"
