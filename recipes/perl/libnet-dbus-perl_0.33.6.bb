DESCRIPTION = "Net::DBus - Perl D-Bus module"
SECTION = "libs"
LICENSE = "Artistic|GPL"

PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DA/DANBERR/Net-DBus-${PV}.tar.gz"

S = "${WORKDIR}/Net-DBus-${PV}"

inherit cpan
