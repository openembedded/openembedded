DESCRIPTION = "IO::Zlib - IO:: style interface to Compress::Zlib"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libcompress-zlib-perl-native"
RDEPENDS += "libcompress-zlib-perl"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TO/TOMHUGHES/IO-Zlib-${PV}.tar.gz"

S = "${WORKDIR}/IO-Zlib-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "1abf9e6161cc6c52ccd4c629e32e582e"
SRC_URI[sha256sum] = "8401b31d22605e787edef75025eb048b2b3cfaee92ed8358bdcaedca5761f7ea"
