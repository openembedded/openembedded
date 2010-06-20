DESCRIPTION = "Libcgroup"
PRIORITY = "optional"
SECTION = "libs"
LICENSE = "GPL"
#DEPENDS = "bison-native flex-native"
PR = "r0"

inherit autotools pkgconfig

DEPENDS = "libpam"

SRC_URI = "http://downloads.sourceforge.net/project/libcg/libcgroup/v0.36.2/v0.36.2.rc/libcgroup-0.36.2.rc.tar.bz2"
S = "${WORKDIR}/libcgroup-${PV}.rc"


SRC_URI[md5sum] = "08df957084cba32e2a28ec1e8e8740f5"
SRC_URI[sha256sum] = "35e803a4bf4845bb38ec74cca654e9de5d792758b8b1978a4a699ac6689510c9"

