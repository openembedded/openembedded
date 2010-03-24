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
