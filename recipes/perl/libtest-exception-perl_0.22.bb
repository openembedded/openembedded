DESCRIPTION = "Test::Exception - Test exception based code"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libsub-uplevel-perl-native"
RDEPENDS += "perl-module-base perl-module-carp perl-module-strict \
             libsub-uplevel-perl perl-module-test-builder \
             perl-module-warnings"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/A/AD/ADIE/Test-Exception-${PV}.tar.gz"

S = "${WORKDIR}/Test-Exception-${PV}"

inherit cpan

SRC_URI[md5sum] = "dcf44183af3d26b14d7f989fc5ee1117"
SRC_URI[sha256sum] = "98b129aa38a729f9c63b3ae2118b500f76bcf3456bb03a5f049f67ddea7efc81"
