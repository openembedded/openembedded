DESCRIPTION = "Inkjet driver from linuxprinting.org"
LICENSE = "MIT"
HOMEPAGE = "http://www.linuxprinting.org/ijs/"

SRC_URI = "http://www.linuxprinting.org/ijs/download/ijs-${PV}.tar.bz2"

inherit autotools pkgconfig binconfig lib_package

EXTRA_OECONF = " --enable-shared "

do_stage() {
        autotools_stage_all
}


