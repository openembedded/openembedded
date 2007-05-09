SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r3"

SRC_URI = "http://www.cpan.org/modules/by-module/NetServer/NetServer-Generic-${PV}.tar.gz"

S = "${WORKDIR}/NetServer-Generic-${PV}"

inherit cpan
