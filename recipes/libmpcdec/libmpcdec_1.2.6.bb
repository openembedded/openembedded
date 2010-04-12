DESCRIPTION = "Portable Musepack decoder library"
AUTHOR = "Meni Berman <musepack@gmail.com>"
HOMEPAGE = "http://www.musepack.net"
SECTION = "libs"
LICENSE = "BSD GPL"
PR = "r0"

SRC_URI = "http://files.musepack.net/source/libmpcdec-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF += "ac_cv_func_memcmp_working=yes"

do_configure () {
        oe_runconf
}

do_stage () {
        autotools_stage_all
}

SRC_URI[md5sum] = "7f7a060e83b4278acf4b77d7a7b9d2c0"
SRC_URI[sha256sum] = "4bd54929a80850754f27b568d7891e1e3e1b8d2f208d371f27d1fda09e6f12a8"
