DESCRIPTION = "HTML Parser bits."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

RDEPENDS = "perl-module-test-more \
            perl-module-xsloader \
            perl-module-test-simple \
            libhtml-tagset-perl"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/HTML-Parser-${PV}.tar.gz"

S = "${WORKDIR}/HTML-Parser-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "fb97ea7e5bd832b079d8660732f9d8d9"
SRC_URI[sha256sum] = "0f1365a546e8c54faf5e17c5d011d0b9db8784568fb6b03522ab558ad39d9a63"
