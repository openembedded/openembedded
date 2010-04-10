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

SRC_URI[md5sum] = "bd5785b39675213948a61dea1b400012"
SRC_URI[sha256sum] = "7090a1e6a0d13be2f7e27a724351c61e44ffa5d165a7720bfe505aa2c4d47e14"
