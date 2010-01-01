SECTION = "libs"
LICENSE = "unknown"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DS/DSKOLL/IO-stringy-${PV}.tar.gz"

S = "${WORKDIR}/IO-stringy-${PV}"

inherit cpan

