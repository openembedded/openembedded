DESCRIPTION = "ExtUtils::CBuilder - Compile and link C code for Perl modules"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KW/KWILLIAMS/ExtUtils-CBuilder-${PV}.tar.gz"

S = "${WORKDIR}/ExtUtils-CBuilder-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "d119f0c6c12787a8d5b255208c3c74c5"
SRC_URI[sha256sum] = "fb707b2026de62c1de6ce7fb67e9f82d586211ac09c70e81b83631e77cb47fd1"
