DESCRIPTION = "Test::Output - Utilities to test STDOUT and STDERR messages"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libsub-exporter-perl-native"
RDEPENDS += "libsub-exporter-perl"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SS/SSORICHE/Test-Output-${PV}.tar.gz"

S = "${WORKDIR}/Test-Output-${PV}"

inherit cpan
