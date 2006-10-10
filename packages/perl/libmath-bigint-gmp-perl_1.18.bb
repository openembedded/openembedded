DESCRIPTION = "Math::BigInt::GMP - Use the GMP library for Math::BigInt routines"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "gmp-native"
RDEPENDS += "gmp"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TE/TELS/math/Math-BigInt-GMP-${PV}.tar.gz"

S = "${WORKDIR}/Math-BigInt-GMP-${PV}"

inherit cpan

FILES_${PN} = "${libdir}/perl5/*/*/auto/Math/BigInt/GMP/* \
                ${libdir}/perl5/*/*/auto/Math/BigInt/GMP/.packlist \
                ${libdir}/perl5/*/*/Math"
FILES_${PN}-dbg += "${libdir}/perl5/*/*/auto/Math/BigInt/GMP/.debug"
