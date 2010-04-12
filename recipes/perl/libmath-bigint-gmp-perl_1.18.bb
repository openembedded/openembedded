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

SRC_URI[md5sum] = "cd17afa7e9e7e9192457f6968d538f3f"
SRC_URI[sha256sum] = "6948117f96cc9754bdbc53d92c48bca02f2de844a271a527b0a27065fcd06d24"
