DESCRIPTION = "Math::BigInt::GMP - Use the GMP library for Math::BigInt routines"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
DEPENDS += "gmp-native"
RDEPENDS += "gmp"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TE/TELS/math/Math-BigInt-GMP-${PV}.tar.gz"

S = "${WORKDIR}/Math-BigInt-GMP-${PV}"

inherit cpan
