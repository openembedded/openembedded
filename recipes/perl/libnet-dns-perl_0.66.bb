DESCRIPTION = "Net::DNS - Perl interface to the DNS resolver"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS_${PN} += " \
	libdigest-hmac-perl \
	libdigest-sha \
	libnet-ip-perl \
	perl-module-io-socket \
	perl-module-mime-base64 \
	perl-module-test-more \
	"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/O/OL/OLAF/Net-DNS-${PV}.tar.gz;name=net-dns-perl-${PV}"
SRC_URI[net-dns-perl-0.66.md5sum] = "1635d876324e3c2f6e277d5778bfe94c"
SRC_URI[net-dns-perl-0.66.sha256sum] = "ee922a6ab1403820ad476713d62cb35e7092585ebd628f02865827fcb09d6823"

S = "${WORKDIR}/Net-DNS-${PV}"

inherit cpan
