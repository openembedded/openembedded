DESCRIPTION = "IO-stringy - I/O on in-core objects like strings and arrays"
SECTION = "libs"
LICENSE = "unknown"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DS/DSKOLL/IO-stringy-${PV}.tar.gz"

S = "${WORKDIR}/IO-stringy-${PV}"

inherit cpan

BBCLASSEXTEND="native"
