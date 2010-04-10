DESCRIPTION = "Perl6::Junction - Perl6 style Junction operators in Perl5."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/C/CF/CFRANKS/Perl6-Junction-${PV}.tar.gz"

S = "${WORKDIR}/Perl6-Junction-${PV}"

inherit cpan

SRC_URI[md5sum] = "b014170483cf85a93d08ee59196c53f9"
SRC_URI[sha256sum] = "1428a61246a98411c2f16fcaf051c7acb53fb1507b1982da52d5b6aa70f78c2b"
