DESCRIPTION = "Generic Configuration Module"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TL/TLINDEN/Config-General-${PV}.tar.gz"

S = "${WORKDIR}/Config-General-${PV}"

inherit cpan
