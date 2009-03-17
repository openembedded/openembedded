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
