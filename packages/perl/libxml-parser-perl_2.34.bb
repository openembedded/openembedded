SECTION = "libs"
LICENSE = "Artistic"
PR = "r1"

SRC_URI = "http://www.cpan.org/modules/by-module/XML/XML-Parser-2.34.tar.gz"

S = "${WORKDIR}/XML-Parser-${PV}"

inherit cpan
