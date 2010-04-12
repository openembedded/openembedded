# Exists for compatibility with certain distributions (e.g. Maemo).

require libtool.inc
PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${GNU_MIRROR}/libtool/libtool-${PV}.tar.gz \
           file://autotools.patch;patch=1"
S = "${WORKDIR}/libtool-${PV}"

PACKAGES = "libltdl libltdl-dbg libltdl-dev ${PN} ${PN}-doc"
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

SRC_URI[md5sum] = "f9b709f4ac6d094afdee9cdbe1c6ffe7"
SRC_URI[sha256sum] = "eb95567b78f00208c4932b8ea2f157059db9b58efcec515fa62c5bcb95670f04"
