DESCRIPTION = "Math::BigInt::GMP - Use the GMP library for Math::BigInt routines"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "gmp-native"
RDEPENDS += "gmp"
PR = "r6"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TE/TELS/math/Math-BigInt-GMP-${PV}.tar.gz"

S = "${WORKDIR}/Math-BigInt-GMP-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/Math/BigInt/GMP/* \
                ${PERLLIBDIRS}/Math"
