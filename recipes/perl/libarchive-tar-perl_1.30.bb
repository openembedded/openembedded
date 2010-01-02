DESCRIPTION = "Archive::Tar - module for manipulations of tar archives"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libio-zlib-perl-native"
RDEPENDS += "libio-zlib-perl"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KA/KANE/Archive-Tar-${PV}.tar.gz"

S = "${WORKDIR}/Archive-Tar-${PV}"

inherit cpan

BBCLASSEXTEND="native"
