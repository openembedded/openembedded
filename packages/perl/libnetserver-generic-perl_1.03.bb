SECTION = "libs"
LICENSE = "Artistic|GPL"
SRC_URI = "http://www.cpan.org/modules/by-module/NetServer/NetServer-Generic-${PV}.tar.gz"
DEPENDS = "perl"
S = "${WORKDIR}/NetServer-Generic-${PV}"

inherit cpan
