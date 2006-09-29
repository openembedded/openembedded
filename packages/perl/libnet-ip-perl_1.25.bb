DESCRIPTION = "Net::IP - Perl extension for manipulating IPv4/IPv6 addresses"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
DEPENDS += "libio-zlib-perl-native"
RDEPENDS += "libio-zlib-perl"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MANU/Net-IP-1.25.tar.gz"

S = "${WORKDIR}/Net-IP-${PV}"

inherit cpan
