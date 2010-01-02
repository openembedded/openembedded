DESCRIPTION = "Sub::Uplevel - apparently run a function in a higher stack frame"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-exporter perl-module-strict perl-module-vars"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DA/DAGOLDEN/Sub-Uplevel-${PV}.tar.gz"

S = "${WORKDIR}/Sub-Uplevel-${PV}"

inherit cpan

BBCLASSEXTEND="native"
