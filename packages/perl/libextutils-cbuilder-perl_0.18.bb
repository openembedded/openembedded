DESCRIPTION = "ExtUtils::CBuilder - Compile and link C code for Perl modules"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/ExtUtils-CBuilder-0.18.tar.gz"

S = "${WORKDIR}/ExtUtils-CBuilder-${PV}"

inherit cpan
