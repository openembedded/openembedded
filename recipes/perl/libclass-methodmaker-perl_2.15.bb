DESCRIPTION = "Class::MethodMaker - Create generic methods for OO Perl"
SECTION = "libs"
LICENSE = "unknown|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SC/SCHWIGON/class-methodmaker/Class-MethodMaker-${PV}.tar.gz"

S = "${WORKDIR}/Class-MethodMaker-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "7af92ddaee49815ade7c5886b74d5e64"
SRC_URI[sha256sum] = "7b06802a72b1891c650fdf00d0ed0386caa379b37b0759c29d2d75aaa3dc3958"
