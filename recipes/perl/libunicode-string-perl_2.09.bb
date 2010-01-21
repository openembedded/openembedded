DESCRIPTION = "Unicode::String - String of Unicode characters (UTF-16BE)"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/Unicode-String-${PV}.tar.gz"

S = "${WORKDIR}/Unicode-String-${PV}"

inherit cpan

BBCLASSEXTEND="native"
