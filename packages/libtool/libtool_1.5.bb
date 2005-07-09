LICENSE = "GPL"
SECTION = "devel"
DESCRIPTION = "Generic library support script \
This is GNU libtool, a generic library support script.  Libtool hides \
the complexity of generating special library types (such as shared \
libraries) behind a consistent interface."
PR = "r1"

SRC_URI = "${GNU_MIRROR}/libtool/libtool-${PV}.tar.gz \
           file://autotools.patch;patch=1"
S = "${WORKDIR}/libtool-${PV}"

inherit autotools

EXTRA_AUTORECONF = "--exclude=libtoolize"

PACKAGES = "libltdl libltdl-dev ${PN}"
FILES_${PN} += "${datadir}/aclocal*"
FILES_libltdl = "${libdir}/libltdl.so.*"
FILES_libltdl-dev = "${libdir}/libltdl.* ${includedir}/ltdl.h"

do_configure () {
	find ${S} -name acinclude.m4 | for m4 in `cat`; do
		cat ${S}/libtool.m4 ${S}/ltdl.m4 > $m4
	done
	autotools_do_configure
}
