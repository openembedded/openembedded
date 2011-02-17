DESCRIPTION = "This software provides support for the Tag Image File Format (TIFF)"
LICENSE = "${PN}"
HOMEPAGE = "http://www.remotesensing.org/libtiff/"
DEPENDS = "zlib jpeg lzo"
PV = "3.9.4+4.0.0beta6"

PR = "r1"

SRC_URI = "http://download.osgeo.org/libtiff/tiff-4.0.0beta6.tar.gz \
	   file://tiff-lp589145.diff;striplevel=0 \
	   file://tiff-ojpeg-null-stripbytecount.diff;striplevel=0"
SRC_URI[md5sum] = "6a1e51841a5a5062cc381e34a48122a0"
SRC_URI[sha256sum] = "de016175742bcdd0cd6f326dd2e7bbc7154437d7bb09976ad4789016065061e6"

S = "${WORKDIR}/tiff-4.0.0beta6"

inherit autotools

EXTRA_OECONF = "--without-x --disable-rpath"

do_configure_append() {
    # Fix RPATH issues.
    sed -i ${S}/config.status -e s,^\\\(hardcode_into_libs=\\\).*$,\\1\'no\',
    ${S}/config.status
}

PACKAGES =+ "tiffxx tiffxx-dbg tiffxx-dev tiff-utils tiff-utils-dbg"
FILES_tiffxx = "${libdir}/libtiffxx.so.*"
FILES_tiffxx-dev = "${libdir}/libtiffxx.so ${libdir}/libtiffxx.*a"
FILES_tiffxx-dbg += "${libdir}/.debug/libtiffxx.so*"
FILES_tiff-utils = "${bindir}/*"
FILES_tiff-utils-dbg += "${bindir}/.debug/"

BBCLASSEXTEND = "native"
