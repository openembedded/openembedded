DESCRIPTION = "Programmable DNS resolver class for offline emulation of DNS"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS_${PN} += " \
	libnet-dns-perl \
	perl-module-module-build \
	perl-module-version \
	"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JM/JMEHNLE/net-dns-resolver-programmable/Net-DNS-Resolver-Programmable-v${PV}.tar.gz;name=net-dns-resolver-programmable-perl-${PV}"
SRC_URI[net-dns-resolver-programmable-perl-0.003.md5sum] = "8d44bf331d6115e7fb4ea21f6cf4b96b"
SRC_URI[net-dns-resolver-programmable-perl-0.003.sha256sum] = "8d402260941f259c83bf1b2564408e75288df028f604136c29da11a9a6a076ec"

S = "${WORKDIR}/Net-DNS-Resolver-Programmable-v${PV}"

inherit cpan_build

PACKAGE_ARCH = "all"
