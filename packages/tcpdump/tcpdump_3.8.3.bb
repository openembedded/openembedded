DESCRIPTION = "A sophisticated network protocol dumper"
HOMEPAGE = "http://www.tcpdump.org/"
LICENSE = "BSD"
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "libpcap-0.8.3"
PR = "r1"

SRC_URI = "http://www.tcpdump.org/release/tcpdump-${PV}.tar.gz \
           file://fix-paths.patch;patch=1"

inherit autotools 

do_configure() {
	gnu-configize
	oe_runconf
}
