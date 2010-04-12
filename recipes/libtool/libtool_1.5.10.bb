require libtool.inc
PR = "${INC_PR}.0"

SRC_URI = "${GNU_MIRROR}/libtool/libtool-${PV}.tar.gz \
           file://autotools.patch;patch=1 \
	   file://uclibc.patch;patch=1 \
	   file://3figures.patch;patch=1"
S = "${WORKDIR}/libtool-${PV}"

PACKAGES =+ "libltdl libltdl-dev libltdl-dbg"
FILES_${PN} += "${datadir}/aclocal*"
FILES_libltdl = "${libdir}/libltdl.so.*"
FILES_libltdl-dev = "${libdir}/libltdl.* ${includedir}/ltdl.h"
FILES_libltdl-dbg += "${libdir}/.debug/"

inherit autotools

EXTRA_AUTORECONF = "--exclude=libtoolize"

do_configure () {
	find ${S} -name acinclude.m4 | for m4 in `cat`; do
		cat ${S}/libtool.m4 ${S}/ltdl.m4 > $m4
	done
	autotools_do_configure
}

do_stage () {
	oe_libinstall -a -so -C libltdl libltdl ${STAGING_LIBDIR}
	install -m 0644 libltdl/ltdl.h ${STAGING_INCDIR}/
}

SRC_URI[md5sum] = "e2093a85f6d48f1562c36920087502d6"
SRC_URI[sha256sum] = "6524e6d7a4adbda7fcda27ecd7b08bbeab88ad59d81bc6b166c617530f3dee1a"
