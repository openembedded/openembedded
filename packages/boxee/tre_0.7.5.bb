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

