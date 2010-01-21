DESCRIPTION = "Various MIME modules."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

RDEPENDS = "perl-module-scalar-util \
            perl-module-file-spec \
            perl-module-storable \
            perl-module-test-simple"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TI/TIMB/DBI-${PV}.tar.gz"

S = "${WORKDIR}/DBI-${PV}"

inherit cpan

BBCLASSEXTEND="native"
