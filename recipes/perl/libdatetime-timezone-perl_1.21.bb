DESCRIPTION = "DateTime - A date and time object"
SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://datetime.perl.org/"
DEPENDS = "libclass-singleton-perl libparams-validate-perl"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/DateTime-TimeZone-${PV}.tar.gz"
SRC_URI[md5sum] = "442c2754c061b61e30f04e57954abba3"
SRC_URI[sha256sum] = "febec17fc7428e5ff897f1772d3e230f2b8e3afbc94558dc2a60b092608c90c6"

S = "${WORKDIR}/DateTime-TimeZone-${PV}"

inherit cpan

BBCLASSEXTEND="native"
