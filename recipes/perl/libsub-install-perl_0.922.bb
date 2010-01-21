DESCRIPTION = "Sub::Install - install subroutines into packages easily"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-carp perl-module-scalar-util perl-module-strict \
             perl-module-warnings"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/Sub-Install-${PV}.tar.gz"

S = "${WORKDIR}/Sub-Install-${PV}"

inherit cpan

BBCLASSEXTEND="native"
