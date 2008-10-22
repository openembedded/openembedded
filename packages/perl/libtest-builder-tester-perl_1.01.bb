DESCRIPTION = "Test::Builder::Tester - test testsuites that have been built with Test::Builder"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-strict perl-module-carp perl-module-exporter \
             perl-module-symbol perl-module-vars"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MARKF/Test-Builder-Tester-${PV}.tar.gz"

S = "${WORKDIR}/Test-Builder-Tester-${PV}"

inherit cpan
