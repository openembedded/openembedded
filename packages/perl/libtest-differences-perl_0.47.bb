DESCRIPTION = "Test::Differences - Test strings and data structures and show differences if not ok"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libtext-diff-perl-native"
RDEPENDS += "perl-module-carp perl-module-constant perl-module-exporter \
             perl-module-strict libtext-diff-perl"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RB/RBS/Test-Differences-${PV}.tar.gz"

S = "${WORKDIR}/Test-Differences-${PV}"

inherit cpan
