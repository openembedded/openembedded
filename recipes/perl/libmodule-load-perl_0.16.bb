DESCRIPTION = "A module loading thingy for perl."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

RDEPENDS = "perl-module-test-more"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KA/KANE/Module-Load-${PV}.tar.gz"

S = "${WORKDIR}/Module-Load-${PV}"

inherit cpan

BBCLASSEXTEND="native"
