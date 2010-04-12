DESCRIPTION= "SDCC - Small Device C Compiler"
LICENSE = "GPL"
SECTION = "devel"
HOMEPAGE = "http://sdcc.sourceforge.net"
DEPENDS = "sdcc-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/sdcc/sdcc-src-${PV}.tar.bz2 \
           file://use-native-tools.patch;patch=1"

S = "${WORKDIR}/sdcc"

PARALLEL_MAKE = ""

inherit autotools


do_configure() {
        gnu-configize
        oe_runconf
}


SRC_URI[md5sum] = "1b9c2e581b92d5e3f13bca37c5784080"
SRC_URI[sha256sum] = "cbb035699d8910c7ca2fa360a773504b44165e98042ed8c208fea2fe47a96557"
