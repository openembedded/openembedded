DESCRIPTION = "X10 support for Perl."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RO/ROBF/X10-${PV}.tar.gz"

S = "${WORKDIR}/X10-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "056b3d98fab545865148b948de6784c7"
SRC_URI[sha256sum] = "2b34d7c2112e8b79856c63f43403bff1a7ed5005d9b98db5f94c6f4cc7ba5623"
