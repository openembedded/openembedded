DESCRIPTION = "IO::Zlib - IO:: style interface to Compress::Zlib"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libcompress-zlib-perl-native"
RDEPENDS += "libcompress-zlib-perl"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TO/TOMHUGHES/IO-Zlib-${PV}.tar.gz;name=io-zlib-${PV}"
SRC_URI[io-zlib-1.10.md5sum] = "078a9387009b928068f70759e61bd08f"
SRC_URI[io-zlib-1.10.sha256sum] = "fda584f55531e5102c350b9490673be3465e356602bf3b3d2a93f3a597f2d4d4"

S = "${WORKDIR}/IO-Zlib-${PV}"

BBCLASSEXTEND="native"

inherit cpan

PACKAGE_ARCH = "all"
