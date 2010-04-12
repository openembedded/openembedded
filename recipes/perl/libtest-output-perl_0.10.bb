DESCRIPTION = "Test::Output - Utilities to test STDOUT and STDERR messages"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libsub-exporter-perl-native"
RDEPENDS += "libsub-exporter-perl"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SS/SSORICHE/Test-Output-${PV}.tar.gz"

S = "${WORKDIR}/Test-Output-${PV}"

inherit cpan

SRC_URI[md5sum] = "dcf67296e04a41a9f73f70c10fe5f825"
SRC_URI[sha256sum] = "b72813be2639d49dda2a3f87928b7ce185633f3afaa25300afbfb844b12deea4"
