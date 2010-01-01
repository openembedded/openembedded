DESCRIPTION = "Data::OptList - parse and validate simple name/value option pairs"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libsub-install-perl-native libparams-util-perl-native"
RDEPENDS += "perl-module-list-util libparams-util-perl perl-module-strict \
             libsub-install-perl perl-module-warnings "
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/Data-OptList-${PV}.tar.gz"

S = "${WORKDIR}/Data-OptList-${PV}"

inherit cpan

BBCLASSEXTEND="native"
