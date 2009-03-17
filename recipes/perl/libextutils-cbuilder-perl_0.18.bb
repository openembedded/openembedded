DESCRIPTION = "ExtUtils::CBuilder - Compile and link C code for Perl modules"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/ExtUtils-CBuilder-${PV}.tar.gz"

S = "${WORKDIR}/ExtUtils-CBuilder-${PV}"

inherit cpan
