require libtool.inc
PR = "${INC_PR}.0"

SRC_URI = "${GNU_MIRROR}/libtool/libtool-${PV}.tar.gz"
S = "${WORKDIR}/${BPN}-2.2.6"

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

SRC_URI[md5sum] = "8ca1ea241cd27ff9832e045fe9afe4fd"
SRC_URI[sha256sum] = "eb6b8f8272c5a5cad0c7c6b949aa75632f45c295f09b2e1e90b6bce15b32b796"
