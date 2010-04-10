DESCRIPTION = "Sub::Uplevel - apparently run a function in a higher stack frame"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-exporter perl-module-strict perl-module-vars"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DA/DAGOLDEN/Sub-Uplevel-${PV}.tar.gz"

S = "${WORKDIR}/Sub-Uplevel-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "16ea7df857d28cbf50ef668fe19559f7"
SRC_URI[sha256sum] = "c6e8d8ca900c3bee61b3c66888722b79d232731c9ee8f59533f06a4e486f23ec"
