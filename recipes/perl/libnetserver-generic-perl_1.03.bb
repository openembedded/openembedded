DESCRIPTION = "NetServer::Generic is a perl module that implements an object-oriented interface for developing internet servers."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r4"

SRC_URI = "http://www.cpan.org/modules/by-module/NetServer/NetServer-Generic-${PV}.tar.gz"

S = "${WORKDIR}/NetServer-Generic-${PV}"

inherit cpan
