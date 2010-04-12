DESCRIPTION = "NetServer::Generic is a perl module that implements an object-oriented interface for developing internet servers."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r4"

SRC_URI = "http://www.cpan.org/modules/by-module/NetServer/NetServer-Generic-${PV}.tar.gz"

S = "${WORKDIR}/NetServer-Generic-${PV}"

inherit cpan

SRC_URI[md5sum] = "bbb47b15e1b624e1b728d8ef6ea93268"
SRC_URI[sha256sum] = "174415168e1fc0451f3f6e34beb5c8779b83521a477243cf4ef865be4e161834"
