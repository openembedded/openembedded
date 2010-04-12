DESCRIPTION = "A sophisticated network protocol analyzer"
HOMEPAGE = "http://www.tcpdump.org/"
LICENSE = "BSD"
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "libpcap"

PR = "r1"

SRC_URI = " \
	http://www.tcpdump.org/release/tcpdump-${PV}.tar.gz \
	file://tcpdump_configure_no_-O2.patch;patch=1 \
	file://ipv6-cross.patch;patch=1 \
"

inherit autotools

EXTRA_OECONF = "--without-crypto \
		${@base_contains('DISTRO_FEATURES', 'ipv6', '--enable-ipv6', '--disable-ipv6', d)}"

do_configure() {
	gnu-configize
	oe_runconf
	sed -i 's:/usr/lib:${STAGING_LIBDIR}:' ./Makefile
	sed -i 's:/usr/include:${STAGING_INCDIR}:' ./Makefile
}

SRC_URI[md5sum] = "2aacf4dc9a3bc500a8b4f3887a32cdd5"
SRC_URI[sha256sum] = "09f1daece22a3555f1ca1f9779caf36357cc8d5b9ad1964606093c7e884e0da4"
