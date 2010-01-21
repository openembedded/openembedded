DESCRIPTION = "Net::DBus - Perl extension for the DBus message system"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

RDEPENDS = "perl-module-vars perl-module-locale perl-module-io-handle \
            perl-module-symbol perl-module-selectsaver perl-module-io \
            perl-module-integer perl-module-exporter-heavy"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DA/DANBERR/Net-DBus-${PV}.tar.gz"
S = "${WORKDIR}/Net-DBus-${PV}"

inherit cpan
