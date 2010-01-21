DESCRIPTION = "X10 support for Perl."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RO/ROBF/X10-${PV}.tar.gz"

S = "${WORKDIR}/X10-${PV}"

inherit cpan

BBCLASSEXTEND="native"
