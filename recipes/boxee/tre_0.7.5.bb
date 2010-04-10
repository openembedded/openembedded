DESCRIPTION = "TRE is a lightweight, robust, and efficient POSIX compliant regexp matching library "
LICENSE = "LGPL"

SRC_URI = "http://laurikari.net/tre/tre-${PV}.tar.bz2"

inherit autotools

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
               tre.pc
}

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "e72e5c94008865cf720992a0b25d6e89"
SRC_URI[sha256sum] = "030f25e6e4c1714df013105494bc5e24b3e0acc65887158a52a03efd8e0759aa"
