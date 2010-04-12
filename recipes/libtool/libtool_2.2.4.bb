require libtool.inc
PR = "${INC_PR}.0"

SRC_URI = "${GNU_MIRROR}/libtool/libtool-${PV}.tar.gz"
S = "${WORKDIR}/libtool-${PV}"

PACKAGES =+ "libltdl libltdl-dev libltdl-dbg"
FILES_${PN} += "${datadir}/aclocal*"
FILES_libltdl = "${libdir}/libltdl.so.*"
FILES_libltdl-dev = "${libdir}/libltdl.* ${includedir}/ltdl.h"
FILES_libltdl-dbg = "${libdir}/.debug/"

inherit autotools

EXTRA_AUTORECONF = "--exclude=libtoolize"

do_stage () {
       install -d ${STAGING_INCDIR}/libltdl
       install -m 0644 libltdl/ltdl.h ${STAGING_INCDIR}/
       install -m 0644 libltdl/libltdl/*.h ${STAGING_INCDIR}/libltdl/
       oe_libinstall -a -so -C libltdl libltdl ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "0b87e84c7aad3b5e979bbe35312fd4c1"
SRC_URI[sha256sum] = "b8839214df514d560a202f54c30d1b2e2f443f0798193c9e926c9f9e11218b9c"
