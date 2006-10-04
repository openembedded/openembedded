DESCRIPTION = "ExtUtils::ParseXS - converts Perl XS code into C code"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/ExtUtils-ParseXS-${PV}.tar.gz"

S = "${WORKDIR}/ExtUtils-ParseXS-${PV}"

inherit cpan
