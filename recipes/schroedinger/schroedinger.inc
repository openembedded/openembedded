HOMEPAGE = "http://schrodinger.sourceforge.net/"
LICENSE = "MPL GPL LGPL MIT"
DEPENDS = "liboil orc-native orc"

INC_PR = "r1"

SRC_URI = "http://www.diracvideo.org/download/schroedinger/${P}.tar.gz;name=schroedingertargz"
SRC_URI += "file://configure.ac.patch"

EXTRA_OECONF += "STAGING_DIR=${STAGING_DIR_NATIVE}"

inherit autotools

do_configure_append () {
        # Fix stupid libtool... handling. 
        # rpath handling can't be disabled and the Makefile's can't be regenerated..
        # (GNU sed required)
        sed -i s/^hardcode_libdir_flag_spec/#hardcode_libdir_flag_spec/ ${S}/*-libtool
}
