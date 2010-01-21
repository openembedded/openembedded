DESCRIPTION = "Various MIME modules."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

RDEPENDS = "perl-module-test-more \
            perl-module-time-local"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/Email-Date-Format-${PV}.tar.gz"

S = "${WORKDIR}/Email-Date-Format-${PV}"

inherit cpan

BBCLASSEXTEND="native"
