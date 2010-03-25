DESCRIPTION = "IO::Socket::INET6 - Object interface for AF_INET|AF_INET6 domain sockets"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS_${PN} += "perl-module-test-more libsocket6-perl perl-module-io-socket"
PR = "r0"

BBCLASSEXTEND = "native"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SH/SHLOMIF/IO-Socket-INET6-${PV}.tar.gz;name=io-socket-inet6-perl-${PV}"
SRC_URI[io-socket-inet6-perl-2.57.md5sum] = "65e5224afd57bbe0abfa178a206cedfe"
SRC_URI[io-socket-inet6-perl-2.57.sha256sum] = "85f09b550c2cca9acf650d89514e6774e743d2f53ce8043b9413a639addad16d"

S = "${WORKDIR}/IO-Socket-INET6-${PV}"

inherit cpan

PACKAGE_ARCH = "all"
