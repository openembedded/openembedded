SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS = "perl-module-vars perl-module-locale perl-module-io-handle \
            perl-module-symbol perl-module-selectsaver perl-module-io \
            perl-module-integer perl-module-exporter-heavy"
PR = "r3"

SRC_URI = "http://www.cpan.org/authors/id/G/GU/GUIDO/libintl-perl-${PV}.tar.gz"

S = "${WORKDIR}/libintl-perl-${PV}"

inherit cpan

do_compile() {
	make CC="${CC}" LD="${LD}"
}
