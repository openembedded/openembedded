DESCRIPTION = "MCPP is a portable C/C++ preprocessor"
HOMEPAGE = "http://mcpp.sourceforge.net/"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/${BPN}-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = " --enable-mcpplib "

BBCLASSEXTEND = "native"
