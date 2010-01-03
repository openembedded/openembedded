DESCRIPTION = "Archive::Zip - Provide an interface to ZIP archive files."
SECTION = "libs"
LICENSE = "Artistic|GPL"

DEPENDS += "libio-zlib-perl-native"
RDEPENDS += "libio-zlib-perl"
PR= "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AD/ADAMK/Archive-Zip-${PV}.tar.gz"

S = "${WORKDIR}/Archive-Zip-${PV}"

inherit cpan

BBCLASSEXTEND="native"
