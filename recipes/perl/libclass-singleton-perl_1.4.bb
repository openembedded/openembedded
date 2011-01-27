DESCRIPTION = "Class::Singleton - Implementation of a "Singleton" class"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AB/ABW/Class-Singleton-${PV}.tar.gz"

S = "${WORKDIR}/Class-Singleton-${PV}"
SRC_URI[md5sum] = "a18b108ab97e2107cbbe816d2b3e2ee3"
SRC_URI[sha256sum] = "cfafc6e7c842e04fc11cc3e700551461a6aaa0b139470273aea2f29026e79150"

inherit cpan

BBCLASSEXTEND="native"
