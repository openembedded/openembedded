DESCRIPTION = "Text::Diff - Perform diffs on files and record sets"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libalgorithm-diff-perl-native"
RDEPENDS += "libalgorithm-diff-perl perl-module-carp perl-module-constant \
             perl-module-exporter perl-module-strict perl-module-carp \
             perl-module-strict "
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RB/RBS/Text-Diff-${PV}.tar.gz"

S = "${WORKDIR}/Text-Diff-${PV}"

inherit cpan

BBCLASSEXTEND="native"
