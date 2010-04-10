DESCRIPTION = "Unicode::String - String of Unicode characters (UTF-16BE)"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/Unicode-String-${PV}.tar.gz"

S = "${WORKDIR}/Unicode-String-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "553e68e603723bf7c631f8701ab0d678"
SRC_URI[sha256sum] = "c817bedb954ea2d488bade56059028b99e0198f6826482e2f68fd6d78653faad"
