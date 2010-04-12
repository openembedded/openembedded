DESCRIPTION = "Event-driven component architecture for Perl"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://backpan.cpan.org/modules/by-module/POE/RCAPUTO/POE-${PV}.tar.gz"

S = "${WORKDIR}/POE-${PV}"

inherit cpan

SRC_URI[md5sum] = "c7e8822bd11ed36a2f716f60e58da2e6"
SRC_URI[sha256sum] = "5506b4e59aa455b026c4d92db083e7d6d36021b21a13be43d177276ab7d56a84"
