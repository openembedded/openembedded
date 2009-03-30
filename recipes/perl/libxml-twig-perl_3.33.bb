SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://www.xmltwig.com/"
DEPENDS += "libxml-parser-perl"
PR = "r0"

SRC_URI = "http://xmltwig.com/xmltwig/XML-Twig-${PV}.tar.gz"

S = "${WORKDIR}/XML-Twig-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

