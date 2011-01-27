DESCRIPTION = "Net::IP - Perl extension for manipulating IPv4/IPv6 addresses"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS += "libio-zlib-perl-native"
RDEPENDS_${PN} += "libio-zlib-perl perl-module-math-bigint"
PR = "r8"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MA/MANU/Net-IP-${PV}.tar.gz"

S = "${WORKDIR}/Net-IP-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "a49c0b02a9b793ff60191cdafc0c202e"
SRC_URI[sha256sum] = "4cd6e2202fd88c46d5458d19bbea80e257b6ba0ec57ea3ac8ae94ed48c9a60c7"
