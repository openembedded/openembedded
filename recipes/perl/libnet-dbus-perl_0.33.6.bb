DESCRIPTION = "Net::DBus - Perl D-Bus module"
SECTION = "libs"
LICENSE = "Artistic|GPL"

RDEPENDS = "perl-module-vars perl-module-locale perl-module-io-handle \
            perl-module-symbol perl-module-selectsaver perl-module-io \
            perl-module-integer perl-module-exporter-heavy"

PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DA/DANBERR/Net-DBus-${PV}.tar.gz"

S = "${WORKDIR}/Net-DBus-${PV}"

inherit cpan
