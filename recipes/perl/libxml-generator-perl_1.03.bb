DESCRIPTION = "XML::Generator - Perl extension for generating XML"
SECTION = "libs"
LICENSE = "Artistic|GPL"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/B/BH/BHOLZMAN/XML-Generator-${PV}.tar.gz;name=xml-generator-perl-${PV}"
SRC_URI[xml-generator-perl-1.03.md5sum] = "789d60259eed4517a9989768100abede"
SRC_URI[xml-generator-perl-1.03.sha256sum] = "0bacf7e20718d4b2345c29fd364973d0440866b1e268e115c7a21f55e87448c5"

S = "${WORKDIR}/XML-Generator-${PV}"

BBCLASSEXTEND = "native"

inherit cpan

PACKAGE_ARCH = "all"
