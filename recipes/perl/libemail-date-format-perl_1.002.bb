DESCRIPTION = "Various MIME modules."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

RDEPENDS = "perl-module-test-more \
            perl-module-time-local"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/Email-Date-Format-${PV}.tar.gz"

S = "${WORKDIR}/Email-Date-Format-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "7ae25275da6ab272aa8b40141eac9f82"
SRC_URI[sha256sum] = "0c7f3636dffa5ff151f6906baa17582c2efeb29109750f40f820fe5d2dc38e84"
