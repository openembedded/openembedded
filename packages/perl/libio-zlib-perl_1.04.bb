DESCRIPTION = "IO::Zlib - IO:: style interface to Compress::Zlib"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
DEPENDS = "libcompress-zlib-perl-native"
RDEPENDS += "libcompress-zlib-perl"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TO/TOMHUGHES/IO-Zlib-1.04.tar.gz"

S = "${WORKDIR}/IO-Zlib-${PV}"

inherit cpan
