DESCRIPTION = "Devel::StackTrace - Stack trace and stack trace frame objects"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r7"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Devel-StackTrace-${PV}.tar.gz"

S = "${WORKDIR}/Devel-StackTrace-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "35d85c3f2c91c1de389b13436659551a"
SRC_URI[sha256sum] = "fe044ec9817a31f2b76f701b2cfd980809676943a901ba3d49200162807fa1f9"
