DESCRIPTION = "Expect.pm - Perl Expect interface"
SECTION = "libs"
LICENSE = "Artistic"
PR = "r0"

SRC_URI = "http://www.cpan.org/modules/by-module/Expect/Expect-${PV}.tar.gz"

S = "${WORKDIR}/Expect-${PV}"

inherit cpan
