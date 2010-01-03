DESCRIPTION = "XML::Simple - Easy API to maintain XML (esp config files)"
SECTION = "libs"
LICENSE = "Artistic"
DEPENDS += "libxml-parser-perl"
PR = "r1"

SRC_URI = "http://www.cpan.org/modules/by-module/XML/XML-Simple-${PV}.tar.gz"

S = "${WORKDIR}/XML-Simple-${PV}"

inherit cpan

BBCLASSEXTEND="native"
