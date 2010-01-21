DESCRIPTION = "Term::ReadKey - A perl module for simple terminal control"
SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://search.cpan.org/~jstowe/TermReadKey-2.30/"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JS/JSTOWE/TermReadKey-${PV}.tar.gz"

S = "${WORKDIR}/TermReadKey-${PV}"

inherit cpan

BBCLASSEXTEND="native"
