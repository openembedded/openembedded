DESCRIPTION = "IO-stringy - I/O on in-core objects like strings and arrays"
SECTION = "libs"
LICENSE = "unknown"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DS/DSKOLL/IO-stringy-${PV}.tar.gz"

S = "${WORKDIR}/IO-stringy-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "2e6a976cfa5521e815c1fdf4006982de"
SRC_URI[sha256sum] = "7e3cf438b3938a2692cb502704c0bbfa2c5ec4a5071ab77906a2432126b004ee"
