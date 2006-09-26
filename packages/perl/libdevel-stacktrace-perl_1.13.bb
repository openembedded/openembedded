DESCRIPTION = "Devel::StackTrace - Stack trace and stack trace frame objects"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Devel-StackTrace-1.13.tar.gz"

S = "${WORKDIR}/Devel-StackTrace-${PV}"

inherit cpan
