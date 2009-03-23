DESCRIPTION = "Test::MockModule - Override subroutines in a module for unit testing"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-carp perl-module-scalar-util perl-module-strict \
             perl-module-vars "
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SI/SIMONFLK/Test-MockModule-${PV}.tar.gz"

S = "${WORKDIR}/Test-MockModule-${PV}"

inherit cpan
