DESCRIPTION = "XML::DOM - A perl module for building DOM Level 1 compliant document structures"
SECTION = "libs"
LICENSE = "unknown"

RDEPENDS += "libxml-parser-perl-native libxml-regexp-perl-native \
	libhtml-parser-perl-native libhtml-tagset-perl-native \
	liburi-perl-native libwww-perl-native"

RDEPENDS += "libxml-parser-perl libxml-regexp-perl \
	libhtml-parser-perl libhtml-tagset-perl liburi-perl libwww-perl"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TJ/TJMATHER/XML-DOM-${PV}.tar.gz"

S = "${WORKDIR}/XML-DOM-${PV}"

inherit cpan
