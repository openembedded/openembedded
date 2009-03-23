SECTION = "libs"
# You can redistribute it and/or modify it under the same terms as Perl itself.
LICENSE = "Artistic|GPL"
RDEPENDS += "perl-module-carp perl-module-exporter perl-module-strict perl-module-time-local"
PACKAGE_ARCH = "all"

SRC_URI = "http://www.cpan.org/modules/by-module/Time/TimeDate-${PV}.tar.gz"

S = "${WORKDIR}/TimeDate-${PV}"

inherit cpan
