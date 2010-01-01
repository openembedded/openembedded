SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://www.xmltwig.com/"
DEPENDS += "libxml-parser-perl"
PR = "r3"

SRC_URI = "http://www.angstrom-distribution.org/unstable/sources/XML-Twig-${PV}-upstream-keeps-changing-this-tarball-so-we-mirror-our-own.tar.gz"

S = "${WORKDIR}/XML-Twig-${PV}"

inherit cpan

BBCLASSEXTEND="native"
