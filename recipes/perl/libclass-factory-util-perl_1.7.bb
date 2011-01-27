DESCRIPTION = "Class::Factory::Util - Provide utility methods for factory classes"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS = "libmodule-build-perl-native"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Class-Factory-Util-${PV}.tar.gz"
SRC_URI[md5sum] = "aebd79da361b676a7ecd3245fc3d1b3f"
SRC_URI[sha256sum] = "6c516b445b44f87363fb3a148431d31e9ecb5e6f21fb6481c89b2406b6692e26"

S = "${WORKDIR}/Class-Factory-Util-${PV}"

inherit cpan_build

BBCLASSEXTEND="native"
