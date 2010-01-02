DESCRIPTION = "HTML Parser bits."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

RDEPENDS = "perl-module-test-more \
            perl-module-xsloader \
            perl-module-test-simple \
            libhtml-tagset-perl"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/HTML-Parser-${PV}.tar.gz"

S = "${WORKDIR}/HTML-Parser-${PV}"

inherit cpan

BBCLASSEXTEND="native"
