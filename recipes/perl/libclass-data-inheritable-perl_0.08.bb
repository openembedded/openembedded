DESCRIPTION = "Class::Data::Inheritable - Inheritable, overridable class data"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r7"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TM/TMTM/Class-Data-Inheritable-${PV}.tar.gz"

S = "${WORKDIR}/Class-Data-Inheritable-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "fc0fe65926eb8fb932743559feb54eb9"
SRC_URI[sha256sum] = "9967feceea15227e442ec818723163eb6d73b8947e31f16ab806f6e2391af14a"
