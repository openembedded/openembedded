DESCRIPTION = "Test::Differences - Test strings and data structures and show differences if not ok"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS += "libtext-diff-perl-native"
RDEPENDS_${PN} += "perl-module-carp perl-module-constant perl-module-exporter \
             perl-module-strict libtext-diff-perl"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RB/RBS/Test-Differences-${PV}.tar.gz"

S = "${WORKDIR}/Test-Differences-${PV}"

inherit cpan

SRC_URI[md5sum] = "e4fa76bb11b0d1db2d4213390413f5af"
SRC_URI[sha256sum] = "d7d17925c23a69d66073e44feee3177186b45ca64c23b73277a4b4100dcdeeeb"
