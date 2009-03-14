SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://search.cpan.org/dist/XML-Writer/"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JO/JOSEPHW/XML-Writer-${PV}.tar.gz"

S = "${WORKDIR}/XML-Writer-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

