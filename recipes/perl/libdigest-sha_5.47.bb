DESCRIPTION = "Digest::SHA - Perl extension for SHA-1/224/256/384/512"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "expat expat-native"
BBCLASSEXTEND = "native"
PR = "r0"

SRC_URI = "http://www.cpan.org/modules/by-module/Digest/Digest-SHA-${PV}.tar.gz"

S = "${WORKDIR}/Digest-SHA-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto ${PERLLIBDIRS}/Digest ${datadir}/perl5"

SRC_URI[md5sum] = "03ff8e4ea73a1c2c5de005d5e4160e94"
SRC_URI[sha256sum] = "9d17d884d6a77005bbac581628d9e30cb5edde72cda1dce98c6536a25b8369f6"
