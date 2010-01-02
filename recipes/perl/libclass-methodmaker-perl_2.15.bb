DESCRIPTION = "Class::MethodMaker - Create generic methods for OO Perl"
SECTION = "libs"
LICENSE = "unknown|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SC/SCHWIGON/class-methodmaker/Class-MethodMaker-${PV}.tar.gz"

S = "${WORKDIR}/Class-MethodMaker-${PV}"

inherit cpan

BBCLASSEXTEND="native"
