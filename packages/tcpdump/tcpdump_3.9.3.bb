DESCRIPTION = "A sophisticated network protocol analyzer"
HOMEPAGE = "http://www.tcpdump.org/"
LICENSE = "BSD"
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "libpcap-0.9.3"
PR = "r2"

SRC_URI = "http://www.tcpdump.org/release/tcpdump-${PV}.tar.gz \
           file://tcpdump_configure_no_-O2.patch;patch=1"

inherit autotools 

EXTRA_OECONF = "--without-crypto"

do_configure() {
	gnu-configize
	oe_runconf
        sed -i 's:/usr/lib:${STAGING_LIBDIR}:' ./Makefile
        sed -i 's:/usr/include:${STAGING_INCDIR}:' ./Makefile
}
