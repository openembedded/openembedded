DESCRIPTION ="XML::XPath - a set of modules for parsing and evaluating XPath statement"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MS/MSERGEANT/XML-XPath-${PV}.tar.gz"
SRC_URI[md5sum] = "b5919d9220d83982feb6e2321850c5d7"
SRC_URI[sha256sum] = "2a49c2df34007588397bdf7ae5f122df72a9499df5cbec8fbc6ad4a31a775576"

S = "${WORKDIR}/XML-XPath-${PV}"

inherit cpan

BBCLASSEXTEND="native"
