DESCRIPTION = "Unicode::UTF8simple - Conversions to/from UTF8 from/to charactersets"
SECTION = "libs"
LICENSE = "unknown"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GU/GUS/Unicode-UTF8simple-${PV}.tar.gz"

S = "${WORKDIR}/Unicode-UTF8simple-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "1d90907170ed41690a572a2d6ed6e7da"
SRC_URI[sha256sum] = "e1249ac08daceb8a83c170c00810001f15d73418e9595711bee663d0130c0fe5"
