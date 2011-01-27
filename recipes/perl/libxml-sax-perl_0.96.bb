DESCRIPTION = "XML-SAX"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS += "libxml-namespacesupport-perl-native"
RDEPENDS_${PN} += "libxml-namespacesupport-perl perl-module-file-temp"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GR/GRANTM/XML-SAX-${PV}.tar.gz;name=sax"
SRC_URI[sax.md5sum] = "bdcd4119a62505184e211e9dfaef0ab1"
SRC_URI[sax.sha256sum] = "9bbef613afa42c46df008d537decc5a61df7e92d65463f3c900769f39e5c8e08"

S = "${WORKDIR}/XML-SAX-${PV}"

inherit cpan

BBCLASSEXTEND = "native"
