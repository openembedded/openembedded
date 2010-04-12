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

SRC_URI[md5sum] = "a1dbce89b1b839fd0e46d74067ae2e35"
SRC_URI[sha256sum] = "6697ad5e1efa3070bad75fd542561c65c81f92154c91b932895a5975adccd0ac"
