DESCRIPTION = "Unicode::UTF8simple - Conversions to/from UTF8 from/to charactersets"
SECTION = "libs"
LICENSE = "unknown"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GU/GUS/Unicode-UTF8simple-${PV}.tar.gz"

S = "${WORKDIR}/Unicode-UTF8simple-${PV}"

inherit cpan

BBCLASSEXTEND="native"
