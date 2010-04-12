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

SRC_URI[md5sum] = "46c2e55d9fb97f2036ccd3b31b3a4533"
SRC_URI[sha256sum] = "f17518340fdad559188c640e97087fcc61446b0986f314df2c7cde53f005130f"
