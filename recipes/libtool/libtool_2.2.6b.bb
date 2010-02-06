require libtool.inc
PR = "${INC_PR}.0"

SRC_URI = "${GNU_MIRROR}/libtool/libtool-${PV}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "07da460450490148c6d2df0f21481a25"
SRC_URI[archive.sha256sum] = "efe133e1014bca96998536f2e565a14fe0fde20cc83ff67135451e4e4e64ad57"

S = "${WORKDIR}/${BPN}-2.2.6b"

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
