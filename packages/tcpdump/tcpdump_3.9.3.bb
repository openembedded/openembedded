DESCRIPTION = "A sophisticated network protocol analyzer"
HOMEPAGE = "http://www.tcpdump.org/"
LICENSE = "BSD"
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "libpcap-0.9.3 openssl"
PR = "r0"

SRC_URI = "http://www.tcpdump.org/release/tcpdump-${PV}.tar.gz"

inherit autotools 

do_configure() {
	gnu-configize
	oe_runconf
}

