DESCRIPTION = "Term::ReadKey - A perl module for simple terminal control"
SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://search.cpan.org/~jstowe/TermReadKey-2.30/"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JS/JSTOWE/TermReadKey-${PV}.tar.gz"

S = "${WORKDIR}/TermReadKey-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "f0ef2cea8acfbcc58d865c05b0c7e1ff"
SRC_URI[sha256sum] = "8c4c70bf487f2e432046dce07cf4b77ff181667d0905f9cb1203ff95ff5dd5ff"
