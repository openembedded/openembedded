DESCRIPTION = "Test::Builder::Tester - test testsuites that have been built with Test::Builder"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-strict perl-module-carp perl-module-exporter \
             perl-module-symbol perl-module-vars"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MARKF/Test-Builder-Tester-${PV}.tar.gz"

S = "${WORKDIR}/Test-Builder-Tester-${PV}"

inherit cpan

SRC_URI[md5sum] = "4751252f1e33af4f582c8af4c7b7666f"
SRC_URI[sha256sum] = "62bc416ccb3f01c3911d9744d6c865d9fa4d008bd47dbecc2adde5c3892ce868"
