DESCRIPTION = "Devel::StackTrace - Stack trace and stack trace frame objects"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Devel-StackTrace-${PV}.tar.gz"

S = "${WORKDIR}/Devel-StackTrace-${PV}"

inherit cpan
