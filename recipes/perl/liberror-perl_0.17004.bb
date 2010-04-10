DESCRIPTION = "Error - Error/exception handling in an OO-ish way"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r8"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PE/PEVANS/Error-${PV}.tar.gz"

S = "${WORKDIR}/Error-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "4dfca8732331a4f79c6803c3bc6b722f"
SRC_URI[sha256sum] = "f464f0068772c276b81a7345f6788bdc3a243c13de24563346043d049a5497ba"
