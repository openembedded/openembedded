DESCRIPTION = "ExtUtils::PkgConfig - makefile generation"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MS/MSCHWERN/ExtUtils-MakeMaker-${PV}.tar.gz"

S = "${WORKDIR}/ExtUtils-MakeMaker-${PV}"

inherit cpan
