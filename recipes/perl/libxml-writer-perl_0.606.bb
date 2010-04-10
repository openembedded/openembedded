DESCRIPTION = "XML::Writer - Perl extension for writing XML documents."
SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://search.cpan.org/dist/XML-Writer/"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JO/JOSEPHW/XML-Writer-${PV}.tar.gz"

S = "${WORKDIR}/XML-Writer-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "178895f6b011594f425d0a2aef0ee069"
SRC_URI[sha256sum] = "49c398574f7796f9f51abf8e13e864bbaa1792af781624a663c9182a9bf777ad"
