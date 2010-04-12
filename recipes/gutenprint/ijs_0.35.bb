DESCRIPTION = "Inkjet driver from linuxprinting.org"
LICENSE = "MIT"
HOMEPAGE = "http://www.linuxprinting.org/ijs/"

SRC_URI = "http://www.linuxprinting.org/ijs/download/ijs-${PV}.tar.bz2"

inherit autotools pkgconfig binconfig lib_package

EXTRA_OECONF = " --enable-shared "

do_stage() {
        autotools_stage_all
}



SRC_URI[md5sum] = "896fdcb7a01c586ba6eb81398ea3f6e9"
SRC_URI[sha256sum] = "11a5f5084488c480f3ff5a24d64d7147bb64272bf60a0ba51330a56c5b50cab9"
