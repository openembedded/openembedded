DESCRIPTION = "The Getfem++ project focuses on the development of a generic and efficient C++ library for finite element methods."
LICENSE = "LGPLv2"

inherit autotools

SRC_URI = "http://download.gna.org/getfem/stable/gmm-3.0.tar.gz"

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
        autotools_stage_all
}

