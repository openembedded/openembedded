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
