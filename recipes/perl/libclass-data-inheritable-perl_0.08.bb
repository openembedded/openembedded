DESCRIPTION = "Class::Data::Inheritable - Inheritable, overridable class data"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r7"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TM/TMTM/Class-Data-Inheritable-${PV}.tar.gz"

S = "${WORKDIR}/Class-Data-Inheritable-${PV}"

inherit cpan

BBCLASSEXTEND="native"
