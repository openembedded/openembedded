DESCRIPTION = "Interface to pcap(3) LBL packet capture library"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libpcap"
RDEPENDS_${PN} += " \
	perl-module-socket \
	perl-module-test-more \
	perl-module-xsloader \
	"

PR = "r0"

export STAGING_LIBDIR

SRC_URI = " \
	http://search.cpan.org/CPAN/authors/id/S/SA/SAPER/Net-Pcap-${PV}.tar.gz;name=net-pcap-perl-${PV} \
	file://kill-runtime-pcap-check-fake-functions-check.patch;patch=1 \
	"
SRC_URI[net-pcap-perl-0.16.md5sum] = "b150d8e0a40137fad2a7df792d80cab4"
SRC_URI[net-pcap-perl-0.16.sha256sum] = "9311d0d4043ea1f8b855dd1f2dc3312436064f4291c74127eb7c3f79b14677aa"

S = "${WORKDIR}/Net-Pcap-${PV}"

inherit cpan
