DESCRIPTION = "A simple tree object"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
RDEPENDS_${PN} += "perl-module-test-more perl-module-scalar-util"
PR = "r1"

PACKAGE_ARCH = "all"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/ST/STEVAN/Tree-Simple-1.18.tar.gz"
SRC_URI[md5sum] = "70462938108a8b8658b1b1d2f12dbeab"
SRC_URI[sha256sum] = "cfbcdf0e02fb94134e1308ef5c3feb4ca4d4ff4cc4199b14fa9be7821183622d"

S = "${WORKDIR}/Tree-Simple-${PV}"

inherit cpan
