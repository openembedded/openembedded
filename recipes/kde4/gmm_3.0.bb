DESCRIPTION = "The Getfem++ project focuses on the development of a generic and efficient C++ library for finite element methods."
LICENSE = "LGPLv2"

inherit autotools

SRC_URI = "http://download.gna.org/getfem/stable/gmm-3.0.tar.gz"

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
        autotools_stage_all
}


SRC_URI[md5sum] = "e543571d8812357374699491014abd58"
SRC_URI[sha256sum] = "f7fad050ce4641a43c2249fd691e514a0ee6afc09b4ec54c8c30038d0c2783d1"
