SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://search.cpan.org/~jstowe/TermReadKey-2.30/"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JS/JSTOWE/TermReadKey-${PV}.tar.gz"

S = "${WORKDIR}/TermReadKey-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

