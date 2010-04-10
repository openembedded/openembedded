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

SRC_URI[md5sum] = "fac4674945f53509ce8c3249646aaa11"
SRC_URI[sha256sum] = "204b2f222f0b41ba969f5a508857edd5e825d8f3a7da816e41b3965ed8524181"
