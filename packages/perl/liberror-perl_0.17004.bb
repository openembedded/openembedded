DESCRIPTION = "Error - Error/exception handling in an OO-ish way"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PE/PEVANS/Error-0.17004.tar.gz"

S = "${WORKDIR}/Error-${PV}"

inherit cpan
