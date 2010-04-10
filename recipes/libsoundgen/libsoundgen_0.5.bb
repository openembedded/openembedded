SECTION = "x11/libs"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig
LICENSE = "LGPL"
DEPENDS = "esound"


do_stage() {
       autotools_stage_all
}


SRC_URI[md5sum] = "de41eed3de2bb441969db8254dc0c889"
SRC_URI[sha256sum] = "08bc3bf18fdd5b27eb554e3cb0c2f0c2805f470909f21a09df26bc8fb8732fd7"
