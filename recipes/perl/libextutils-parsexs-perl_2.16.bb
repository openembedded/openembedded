DESCRIPTION = "ExtUtils::ParseXS - converts Perl XS code into C code"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/ExtUtils-ParseXS-${PV}.tar.gz"

S = "${WORKDIR}/ExtUtils-ParseXS-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "c64fddf17ee2b27d8a90ceb455c3e570"
SRC_URI[sha256sum] = "1f8504c7f08d2d59c71a70915fc834a285b99587444ee33e23ee3f135c071da0"
