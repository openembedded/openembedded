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

SRC_URI[md5sum] = "26ceb6357e855b9e7aad5a5fd66d493e"
SRC_URI[sha256sum] = "7e5396568c9cf12e773802c80507b7dac1bd4635e2c6a052bd994fe62638271a"
