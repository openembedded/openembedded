DESCRIPTION = "Test::MockModule - Override subroutines in a module for unit testing"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-carp perl-module-scalar-util perl-module-strict \
             perl-module-vars "
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SI/SIMONFLK/Test-MockModule-${PV}.tar.gz"

S = "${WORKDIR}/Test-MockModule-${PV}"

inherit cpan

SRC_URI[md5sum] = "1b013aeeb221f83e7f325a2f98169296"
SRC_URI[sha256sum] = "67c515258c76780009e58305ec56f195e1b110d0cabb52792d57dd1761396e07"
