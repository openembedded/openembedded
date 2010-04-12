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

SRC_URI[md5sum] = "4931662ea353384dec2a54a71b26ee8c"
SRC_URI[sha256sum] = "0b654cd39126333a0dab7fdd2fd0c5023f6eb45e72d1d8bf9fb3cab175002bc7"
