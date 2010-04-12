DESCRIPTION = "libintl-perl is an internationalization library for Perl"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS = "perl-module-vars perl-module-locale perl-module-io-handle \
            perl-module-symbol perl-module-selectsaver perl-module-io \
            perl-module-integer perl-module-exporter-heavy"
PR = "r4"

SRC_URI = "http://www.cpan.org/authors/id/G/GU/GUIDO/libintl-perl-${PV}.tar.gz"

S = "${WORKDIR}/libintl-perl-${PV}"

inherit cpan

SRC_URI[md5sum] = "7dfcd9ac3a4ff41038a2c67a733d42b9"
SRC_URI[sha256sum] = "1a64895c9a6cdbb5cdfff81f1520541fee28e85fb940d9b0484de656d69ae8f5"
