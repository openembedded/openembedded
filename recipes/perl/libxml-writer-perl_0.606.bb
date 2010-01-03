DESCRIPTION = "XML::Writer - Perl extension for writing XML documents."
SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://search.cpan.org/dist/XML-Writer/"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JO/JOSEPHW/XML-Writer-${PV}.tar.gz"

S = "${WORKDIR}/XML-Writer-${PV}"

inherit cpan

BBCLASSEXTEND="native"
