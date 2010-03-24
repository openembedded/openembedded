DESCRIPTION = "Net::CIDR - Manipulate IPv4/IPv6 netblocks in CIDR notation"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS_${PN} += "perl-module-carp"

BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MR/MRSAM/Net-CIDR-0.13.tar.gz;name=net-cidr-perl-${PV}"
SRC_URI[net-cidr-perl-0.13.md5sum] = "40f0f42104b314af91ab78119e0096de"
SRC_URI[net-cidr-perl-0.13.sha256sim] = "7011713891c2710dd803d21789df6ba0ad7f4692d5cc1dde83b7106f4b726dab"

S = "${WORKDIR}/Net-CIDR-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
