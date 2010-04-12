DESCRIPTION = "libintl-perl is an internationalization library for Perl"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS = "perl-module-vars perl-module-locale perl-module-io-handle \
            perl-module-symbol perl-module-selectsaver perl-module-io \
            perl-module-integer perl-module-exporter-heavy"
PR = "r0"

SRC_URI = "http://www.cpan.org/authors/id/G/GU/GUIDO/libintl-perl-${PV}.tar.gz"

S = "${WORKDIR}/libintl-perl-${PV}"

inherit cpan

SRC_URI[md5sum] = "cb36f58a7d2e15974f25b35381548b1b"
SRC_URI[sha256sum] = "3036a9d2df85f200631b55a0b01082898c20819d9aabdb9b871508054bee5c67"
