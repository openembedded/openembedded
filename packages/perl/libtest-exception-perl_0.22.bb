DESCRIPTION = "Test::Exception - Test exception based code"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libsub-uplevel-perl-native"
RDEPENDS += "perl-module-base perl-module-carp perl-module-strict \
             libsub-uplevel-perl perl-module-test-builder \
             perl-module-warnings"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AD/ADIE/Test-Exception-${PV}.tar.gz"

S = "${WORKDIR}/Test-Exception-${PV}"

inherit cpan
