SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://search.cpan.org/~uri/"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/File-Slurp-${PV}.tar.gz"

S = "${WORKDIR}/File-Slurp-${PV}"

inherit cpan

