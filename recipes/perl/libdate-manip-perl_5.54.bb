DESCRIPTION = "Date and time manipulation routines."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

RDEPENDS = "perl-module-test-more \
            perl-module-io-file \
            perl-module-carp"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SB/SBECK/Date-Manip-${PV}.tar.gz"

S = "${WORKDIR}/Date-Manip-${PV}"

inherit cpan

BBCLASSEXTEND="native"
