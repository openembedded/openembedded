DESCRIPTION = "IO::Socket::INET6 - Object interface for AF_INET|AF_INET6 domain sockets"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS_${PN} += "perl-module-test-more libsocket6-perl perl-module-io-socket"
PR = "r0"

BBCLASSEXTEND = "native"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SH/SHLOMIF/IO-Socket-INET6-${PV}.tar.gz;name=io-socket-inet6-perl-${PV}"
SRC_URI[io-socket-inet6-perl-2.61.md5sum] = "feba41c2aeea718b2a33ad34615a1dd5"
SRC_URI[io-socket-inet6-perl-2.61.sha256sum] = "a0a40b138f16e16acccd433d36430fca9b0b465db9d9882f01ef033b78cf2e6d"

S = "${WORKDIR}/IO-Socket-INET6-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
