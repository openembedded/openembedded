DESCRIPTION = "Compress::Zlib - Interface to zlib compression library"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "expat expat-native"
PR = "r0"

SRC_URI = "http://www.cpan.org/modules/by-module/IO/IO-Compress-Zlib-${PV}.tar.gz"

S = "${WORKDIR}/IO-Compress-Zlib-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

FILES_${PN} = "${datadir}/perl5"

SRC_URI[md5sum] = "22f3b677a6f1782713c8451966598d3f"
SRC_URI[sha256sum] = "9d25ffdfacb3d43cbae618c68b62264aab2f56a9cf65ad2f974af9dcbae97669"
