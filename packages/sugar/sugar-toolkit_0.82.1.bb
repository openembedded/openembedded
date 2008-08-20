DESCRIPTION = "Sugar toolkit"
LICENSE = "LGPLv2"

DEPENDS = "libxml2 gtk+"

SRC_URI = "http://dev.laptop.org/pub/sugar/sources/sugar-toolkit/sugar-toolkit-${PV}.tar.bz2"

inherit autotools distutils-base

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}

