DESCRIPTION = "TimeDate - parser for absolute times"
SECTION = "libs"
# You can redistribute it and/or modify it under the same terms as Perl itself.
LICENSE = "Artistic|GPL"
PR = "r0"

RDEPENDS += "perl-module-carp perl-module-exporter perl-module-strict perl-module-time-local"
PACKAGE_ARCH = "all"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GB/GBARR/TimeDate-${PV}.tar.gz"

S = "${WORKDIR}/TimeDate-${PV}"

inherit cpan

BBCLASSEXTEND="native"
