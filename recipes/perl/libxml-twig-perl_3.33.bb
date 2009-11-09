SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://www.xmltwig.com/"
DEPENDS += "libxml-parser-perl"
PR = "r1"

SRC_URI = "http://www.angstrom-distribution.org/unstable/sources/XML-Twig-${PV}-upstream-keeps-changing-this-tarball-so-we-mirror-our-own.tar.gz"

S = "${WORKDIR}/XML-Twig-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

