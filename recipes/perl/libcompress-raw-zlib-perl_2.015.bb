SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "expat expat-native"
PR = "r0"

SRC_URI = "http://www.cpan.org/modules/by-module/Compress/Compress-Raw-Zlib-${PV}.tar.gz"

S = "${WORKDIR}/Compress-Raw-Zlib-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto ${PERLLIBDIRS}/Compress ${datadir}/perl5"
