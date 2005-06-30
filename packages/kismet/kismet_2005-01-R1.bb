SECTION = "console/network"
DESCRIPTION = "Kismet is an 802.11 layer2 wireless network detector, sniffer, and intrusion detection system"
HOMEPAGE = "http://www.kismetwireless.net/"
MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"
LICENSE = "GPLv2"
DEPENDS = "expat gmp"

SRC_URI = "http://www.kismetwireless.net/code/kismet-2005-01-R1.tar.gz \
	file://no-strip.diff;patch=1;pnum=0 \
	file://no-chmod.diff;patch=1;pnum=0 \
	file://no-lib-modules-uname-include.diff;patch=1;pnum=0 \
	file://glibc3.3.2-getopt-throw.diff;patch=1;pnum=0"
	

EXTRA_OECONF = "--with-pcap=linux --disable-setuid"

inherit autotools

do_configure() {
	oe_runconf
}


do_install_append() {
	if test -e ${WORKDIR}/kismet.conf; then
		install -m 644 ${WORKDIR}/kismet.conf ${D}${sysconfdir}/
	fi
}

PACKAGES =+ "kismet-sounds"
FILES_kismet-sounds = "/usr/share/kismet/wav"

CONFFILES_${PN}_nylon = "${sysconfdir}/kismet.conf"
