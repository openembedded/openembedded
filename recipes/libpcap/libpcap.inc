DESCRIPTION = "Network Packet Capture Library"
HOMEPAGE = "http://www.tcpdump.org/"
SECTION = "libs/network"
LICENSE = "BSD"
DEPENDS = "bluez-libs flex-native bison-native"

PR = "r3"

# Don't forget to edit shared.patch to have the correct version number inside
SRC_URI = "http://www.tcpdump.org/release/libpcap-${PV}.tar.gz \
           file://shared.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-pcap=linux"

CPPFLAGS_prepend = "-I${S} "
CFLAGS_prepend = "-I${S} "
CXXFLAGS_prepend = "-I${S} "

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cat aclocal.m4 > acinclude.m4
	fi
}

do_install_append () {
	install -d ${D}${includedir}/net
	install -d ${D}${datadir}/aclocal
	ln -sf ../pcap-bpf.h ${D}${includedir}/net/bpf.h
	install -m 0644 acinclude.m4 ${D}${datadir}/aclocal/libpcap.m4
}
