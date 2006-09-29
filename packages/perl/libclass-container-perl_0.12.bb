DESCRIPTION = "Class::Container - Glues object frameworks together transparently"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
DEPENDS = "libparams-validate-perl-native"
RDEPENDS = "libparams-validate-perl"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/Class-Container-0.12.tar.gz"

S = "${WORKDIR}/Class-Container-${PV}"

inherit cpan
