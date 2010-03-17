DESCRIPTION = "IO::Socket::SSL -- Nearly transparent SSL encapsulation for IO::Socket::INET"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS_${PN} += "perl-module-scalar-util libnet-ssleay-perl"
BBCLASSEXTEND = "native"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SU/SULLR/IO-Socket-SSL-${PV}.tar.gz;name=io-socket-ssl-${PV}"
SRC_URI[io-socket-ssl-1.32.md5sum] = "324ec02c26ecb41c481d0586c4174a56"
SRC_URI[io-socket-ssl-1.32.sha256sum] = "79803d103e0dfd14a884802b874b618a24d3bcd88a7192f45ddac83744e21aff"

S = "${WORKDIR}/IO-Socket-SSL-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
