DESCRIPTION = "Archive::Tar - module for manipulations of tar archives"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
DEPENDS += "libio-zlib-perl-native"
RDEPENDS += "libio-zlib-perl"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/K/KA/KANE/Archive-Tar-1.30.tar.gz"

S = "${WORKDIR}/Archive-Tar-${PV}"

inherit cpan
