DESCRIPTION = "PERL database interface driver for the SQLite database."
SECTION = "libs"
LICENSE = "Artistic GPLv1"
DEPENDS += "libdbi-perl-native"
RDEPENDS_${PN} += "libdbi-perl \
         perl-module-file-spec \
         perl-module-file-path \
         perl-module-scalar-util \
         perl-module-list-util \
         perl-module-test \
         perl-module-test-more \
         perl-module-test-harness \
         perl-module-file-basename \
         perl-module-storable \
         perl-module-extutils-makemaker \
         perl-module-locale \
         perl-module-tie-hash \
"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AD/ADAMK/DBD-SQLite-${PV}.tar.gz"
SRC_URI[md5sum] = "67b3575104efd606c8093bc416e3338d"
SRC_URI[sha256sum] = "987e5446dea3dbdfb3aea5b27dbed8526af1733e3eb01ea59a6435ebba5b29f6"

S = "${WORKDIR}/DBD-SQLite-${PV}"

inherit cpan
