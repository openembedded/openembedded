DESCRIPTION = "Net::IP - Perl extension for manipulating IPv4/IPv6 addresses"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "libio-zlib-perl-native"
RDEPENDS += "libio-zlib-perl perl-module-math-bigint"
PR = "r6"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MANU/Net-IP-${PV}.tar.gz"

S = "${WORKDIR}/Net-IP-${PV}"

inherit cpan

BBCLASSEXTEND="native"
