DESCRIPTION = "XML::Twig - A perl module for processing huge XML documents in tree mode."
SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://www.xmltwig.com/"
DEPENDS += "libxml-parser-perl"
PR = "r3"

SRC_URI = "http://www.angstrom-distribution.org/unstable/sources/XML-Twig-${PV}-upstream-keeps-changing-this-tarball-so-we-mirror-our-own.tar.gz"

S = "${WORKDIR}/XML-Twig-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "918f8fba33efe9cf5bc07907c6e46556"
SRC_URI[sha256sum] = "630241ba64685a264d6037cbfed29476ab36fce652746ad5966fcfc9d810abdc"
