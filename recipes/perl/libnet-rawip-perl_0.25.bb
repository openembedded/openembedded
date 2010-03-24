DESCRIPTION = "Perl extension to manipulate raw IP packets with interface to libpcap"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "libpcap"
RDEPENDS = " \
	 perl-module-class-struct \
	 perl-module-data-dumper \
	 perl-module-english \
	 perl-module-getopt-long \
	 perl-module-subs \
	 perl-module-test-more \
	 "

SRC_URI = " \
	http://search.cpan.org/CPAN/authors/id/S/SA/SAPER/Net-RawIP-${PV}.tar.gz;name=net-rawip-perl-${PV} \
	file://kill-pcap-check.patch;patch=1 \
	"
SRC_URI[net-rawip-perl-0.25.md5sum] = "a99f461e20e7894154f64729a4652448"
SRC_URI[net-rawip-perl-0.25.sha256sum] = "6d104b2f0e453eff7a1b479c528798670b15729ed6ecf41430405ff6d7e1ee58"

S = "${WORKDIR}/Net-RawIP-${PV}"

inherit cpan
