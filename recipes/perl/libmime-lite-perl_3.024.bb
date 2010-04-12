DESCRIPTION = "Simple standalone module for generating MIME messages."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

RDEPENDS = "perl-module-file-spec \
            libemail-date-format-perl \
            perl-module-test-more \
            perl-module-time-local"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/MIME-Lite-${PV}.tar.gz"

S = "${WORKDIR}/MIME-Lite-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "ca71d1d844f5c4f693e5079a2b4fa9a5"
SRC_URI[sha256sum] = "886b57c7d8d9903b54dad07b68f58e398745d6d92522e89e2ce714472c09f903"
