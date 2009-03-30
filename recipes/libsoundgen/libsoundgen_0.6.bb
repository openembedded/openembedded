SECTION = "x11/libs"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig
LICENSE = "LGPL"
DEPENDS = "esound"


do_stage() {
       autotools_stage_all
}

