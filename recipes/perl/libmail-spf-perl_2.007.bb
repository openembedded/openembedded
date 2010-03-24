DESCRIPTION = "Mail::SPF - An object-oriented implementation of Sender Policy Framework"
SECTION = "libs"
LICENSE = "BSD"
DEPENDS = " \
	liberror-perl-native \
	libnet-dns-perl-native \
	libnet-dns-resolver-programmable-perl-native \
	libnetaddr-ip-perl-native \
	liburi-perl-native \
	"
RDEPENDS_${PN} += " \
	liberror-perl \
	libnet-dns-perl \
	libnet-dns-resolver-programmable-perl \
	libnetaddr-ip-perl \
	liburi-perl \
	perl-module-module-build \
	perl-module-test-more \
	perl-module-version \
	"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = " \
	http://search.cpan.org/CPAN/authors/id/J/JM/JMEHNLE/mail-spf/Mail-SPF-v${PV}.tar.gz;name=mail-spf-perl-${PV} \
	file://fix-sbin-native-install.patch;patch=1 \
	"
SRC_URI[mail-spf-perl-2.007.md5sum] = "67dccdc91e3264679a0e17d493d3cc30"
SRC_URI[mail-spf-perl-2.007.sha256sum] = "d8886e6a5b300946434284a6527bbb68ed98d27d3582c8e475e338facb96c50b"

S = "${WORKDIR}/Mail-SPF-v${PV}"

inherit cpan_build

PACKAGE_ARCH = "all"
