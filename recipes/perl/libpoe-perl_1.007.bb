DESCRIPTION = "Event-driven component architecture for Perl"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://backpan.cpan.org/modules/by-module/POE/RCAPUTO/POE-${PV}.tar.gz"

S = "${WORKDIR}/POE-${PV}"

inherit cpan
