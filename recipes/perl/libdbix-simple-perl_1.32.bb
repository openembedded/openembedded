DESCRIPTION = "Easy-to-use OO interface to DBI"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS += "libdbi-perl-native"
RDEPENDS_${PN} += "libdbi-perl \
         perl-module-file-spec \
         perl-module-scalar-util \
         perl-module-test-simple \
         perl-module-storable \
"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JU/JUERD/DBIx-Simple-${PV}.tar.gz"
SRC_URI[md5sum] = "c1d7bf0ab453e7e00715d9d4e71102d8"
SRC_URI[sha256sum] = "226917bffbe3ad0e88295046ed4d25785bc6175e696fb77f8302226bc947fe36"

S = "${WORKDIR}/DBIx-Simple-${PV}"

inherit cpan
