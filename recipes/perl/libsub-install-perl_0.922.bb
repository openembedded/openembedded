DESCRIPTION = "Sub::Install - install subroutines into packages easily"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-carp perl-module-scalar-util perl-module-strict \
             perl-module-warnings"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RJ/RJBS/Sub-Install-${PV}.tar.gz"

S = "${WORKDIR}/Sub-Install-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "48e8e9f72cdd5b3f5f7115b8b7de3ddf"
SRC_URI[sha256sum] = "314de5dcc9550a9bff0784a7c9552f8092115452e2a5f4a59903c75bfbf658df"
