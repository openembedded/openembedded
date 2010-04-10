SECTION = "x11/libs"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig
LICENSE = "LGPL"
DEPENDS = "esound"


do_stage() {
       autotools_stage_all
}


SRC_URI[md5sum] = "ce7e2c206c612e2dd09ec42e1179c9a7"
SRC_URI[sha256sum] = "b4d9050bf46dab0f2f3a47911eac255c08159ab3965f5f10c4ab4e903eee1e31"
