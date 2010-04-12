DESCRIPTION = "XML::Simple - Easy API to maintain XML (esp config files)"
SECTION = "libs"
LICENSE = "Artistic"
DEPENDS += "libxml-parser-perl"
PR = "r1"

SRC_URI = "http://www.cpan.org/modules/by-module/XML/XML-Simple-${PV}.tar.gz"

S = "${WORKDIR}/XML-Simple-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "593aa8001e5c301cdcdb4bb3b63abc33"
SRC_URI[sha256sum] = "a54967c188cda3e20f496c83be4de3f1740eeaa83c0380712ecd969ad8766826"
