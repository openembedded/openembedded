DESCRIPTION = "Devel::StackTrace - Stack trace and stack trace frame objects"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r7"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Devel-StackTrace-${PV}.tar.gz"

S = "${WORKDIR}/Devel-StackTrace-${PV}"

inherit cpan

BBCLASSEXTEND="native"
