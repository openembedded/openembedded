DESCRIPTION = "ExtUtils::ParseXS - converts Perl XS code into C code"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/ExtUtils-ParseXS-${PV}.tar.gz"

S = "${WORKDIR}/ExtUtils-ParseXS-${PV}"

inherit cpan

BBCLASSEXTEND="native"
