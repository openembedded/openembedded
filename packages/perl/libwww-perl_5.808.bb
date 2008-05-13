DESCRIPTION = "libwww-perl provides a simple and consistent API to the World Wide Web"
SECTION = "libs"
LICENSE = "Artistic"
DEPENDS = "liburi-perl-native"
RDEPENDS = "liburi-perl"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/libwww-perl-${PV}.tar.gz"

S = "${WORKDIR}/libwww-perl-${PV}"

inherit cpan
