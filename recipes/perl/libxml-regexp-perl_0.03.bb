DESCRIPTION = "XML::RegExp - Regular expressions for XML tokens"
SECTION = "libs"
LICENSE = "unknown"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TJ/TJMATHER/XML-RegExp-${PV}.tar.gz"

S = "${WORKDIR}/XML-RegExp-${PV}"

inherit cpan
