DESCRIPTION = "Class::Inspector - Get information about a class and its structure"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AD/ADAMK/Class-Inspector-${PV}.tar.gz"

S = "${WORKDIR}/Class-Inspector-${PV}"
SRC_URI[md5sum] = "609189b49f64d329a6e413e0a6d8724a"
SRC_URI[sha256sum] = "0a70cac1276d33e5408d3ad4297b3732a2299f7ff463d94ab7d384f2c6b11a66"

inherit cpan

BBCLASSEXTEND="native"
