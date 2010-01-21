DESCRIPTION = "Crypt::Rijndael - Crypt::CBC compliant Rijndael encryption module"
SECTION = "libs"
LICENSE = "GPLv2"
DEPENDS += "expat expat-native"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/B/BD/BDFOY/Crypt-Rijndael-${PV}.tar.gz"

S = "${WORKDIR}/Crypt-Rijndael-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/ \
                ${PERLLIBDIRS}/Crypt"
