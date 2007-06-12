DESCRIPTION = "Class::Container - Glues object frameworks together transparently"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libparams-validate-perl-native"
RDEPENDS = "libparams-validate-perl"
PR = "r6"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/Class-Container-${PV}.tar.gz"

S = "${WORKDIR}/Class-Container-${PV}"

inherit cpan
