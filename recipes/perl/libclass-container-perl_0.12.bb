DESCRIPTION = "Class::Container - Glues object frameworks together transparently"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libparams-validate-perl-native"
RDEPENDS = "libparams-validate-perl"
PR = "r7"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/Class-Container-${PV}.tar.gz"

S = "${WORKDIR}/Class-Container-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "6896bdb4464b96ad638e22b0400acbc9"
SRC_URI[sha256sum] = "771206f2b7a916ce0dfb93d82200472beaeb910248482734179bf36808e486b1"
