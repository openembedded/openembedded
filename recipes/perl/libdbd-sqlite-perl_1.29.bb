DESCRIPTION = "PERL database interface driver for the SQLite database."
SECTION = "libs"
LICENSE = "Artistic GPL"
DEPENDS_${PN} += "libdbi-perl-native"
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
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AD/ADAMK/DBD-SQLite-${PV}.tar.gz;name=dbdsqlite"
SRC_URI[dbdsqlite.md5sum] = "2a47cea6ecff62508775d90151a8030f"
SRC_URI[dbdsqlite.sha256sum] = "51d0d529e453ada1ce85772deb5cc4c86a2ebe9da2dd2fb0b40b77b555720867"

S = "${WORKDIR}/DBD-SQLite-${PV}"

inherit cpan
