DESCRIPTION = "Date and time manipulation routines."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

RDEPENDS = "perl-module-test-more \
            perl-module-io-file \
            perl-module-carp"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SB/SBECK/Date-Manip-${PV}.tar.gz"

S = "${WORKDIR}/Date-Manip-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "16c343329bad644b17f4f8ec5fb243cf"
SRC_URI[sha256sum] = "b61f4f0e3e580723ca7f5c0e1952922c101875535bff04afd772fbd3f193e22a"
