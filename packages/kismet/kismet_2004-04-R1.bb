SECTION = "console/network"
DESCRIPTION = "Kismet is an 802.11 layer2 wireless network detector, sniffer, and intrusion detection system"
HOMEPAGE = "http://www.kismetwireless.net/"
LICENSE = "GPLv2"
MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"
DEPENDS = "expat gmp"

SRC_URI = "http://www.kismetwireless.net/code/kismet-2004-04-R1.tar.gz \
	file://no-strip.diff;patch=1;pnum=0 \
	file://no-chmod.diff;patch=1;pnum=0 \
	file://no-lib-modules-uname-include.diff;patch=1;pnum=0 \
	file://packet_friend_fix.patch;patch=1 \
	file://glibc3.3.2-getopt-throw.diff;patch=1;pnum=0"
	
SRC_URI_append_mtx-1 = " file://kismet.conf"

EXTRA_OECONF = "--with-pcap=linux --disable-setuid"

inherit autotools

do_configure() {
	unset CFLAGS CPPFLAGS
	oe_runconf
}

do_install_append() {
	if test -e ${WORKDIR}/kismet.conf; then
		install -m 644 ${WORKDIR}/kismet.conf ${D}${sysconfdir}/
	fi
}

PACKAGES =+ "kismet-sounds"
FILES_kismet-sounds = "${datadir}/kismet/wav"

CONFFILES_${PN}_nylon = "${sysconfdir}/kismet.conf"
