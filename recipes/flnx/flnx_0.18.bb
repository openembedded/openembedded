SECTION = "x11/libs"
DEPENDS = "microwindows"
RDEPENDS = "microwindows"
DESCRIPTION = "fltk library for microwindows."
SRC_URI = "ftp://ftp.microwindows.org/pub/microwindows/flnx/flnx-${PV}.tar.gz \
	   file://gcc3.patch;patch=1"
S = "${WORKDIR}/flnx"
LICENSE = "LGPL"

inherit autotools

EXTRA_OECONF = "--with-microwin=${STAGING_LIBDIR}/.."

python do_fetch () {
	import os
	bb.build.exec_func("base_do_fetch", d)
	if os.access(bb.data.expand("${DL_DIR}/flnx-${PV}-tar.gz", d), os.R_OK):
		os.rename(bb.data.expand("${DL_DIR}/flnx-${PV}-tar.gz", d), bb.data.expand("${DL_DIR}/flnx-${PV}.tar.gz", d))
}

python do_unpack () {
	src_uri = bb.data.getVar("SRC_URI", d)
	src_uri = src_uri.replace("-tar", ".tar")
	bb.data.setVar("SRC_URI", src_uri, d)
	bb.build.exec_func("base_do_unpack", d)
}

do_install () {
	oe_runmake "bindir=${D}${bindir}" \
		   "libdir=${D}${libdir}" \
		   "includedir=${D}${includedir}" install
}

SRC_URI[md5sum] = "2dfdb9b44a1a08a675985bb92d1439e6"
SRC_URI[sha256sum] = "4a0d868889d5221cc6e4b96f6e8de19bd4fc770fa8e05012c6c169686088088b"
