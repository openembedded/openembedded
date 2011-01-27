DESCRIPTION = "XML::Twig - A perl module for processing huge XML documents in tree mode."
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
HOMEPAGE = "http://www.xmltwig.com/"
DEPENDS += "libxml-parser-perl-native"
RDEPENDS_${PN} += "libxml-parser-perl"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MI/MIROD/XML-Twig-${PV}.tar.gz"
SRC_URI[md5sum] = "867449a4c53c628dd16bdc8de49cfc88"
SRC_URI[sha256sum] = "aa5b841ffe832feca7db16ad4781f01a0bc29ea3e0eb4784ab4d4c12db5922c7"

S = "${WORKDIR}/XML-Twig-${PV}"

inherit cpan

BBCLASSEXTEND="native"
