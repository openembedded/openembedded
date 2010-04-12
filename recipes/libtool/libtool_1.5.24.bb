DEFAULT_PREFERENCE = "-1"

require libtool.inc
PR = "${INC_PR}.0"

SRC_URI = "${GNU_MIRROR}/libtool/libtool-${PV}.tar.gz \
           file://autotools.patch;patch=1 \
	   file://uclibc.patch;patch=1 \
           file://never-ever-do-rpath.patch;patch=1" 

S = "${WORKDIR}/libtool-${PV}"

PACKAGES = "${PN}-dbg libltdl libltdl-dev ${PN}"
FILES_${PN} += "${datadir}/aclocal*"
FILES_libltdl = "${libdir}/libltdl.so.*"
FILES_libltdl-dev = "${libdir}/libltdl.* ${includedir}/ltdl.h"

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

SRC_URI[md5sum] = "d0071c890101fcf4f2be8934a37841b0"
SRC_URI[sha256sum] = "1e54016a76e9704f11eccf9bb73e2faa0699f002b00b6630df82b8882ff2e5b2"
