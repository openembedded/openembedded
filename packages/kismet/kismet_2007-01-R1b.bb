DESCRIPTION = "Kismet is an 802.11 layer2 wireless network detector, sniffer, and intrusion detection system"
HOMEPAGE = "http://www.kismetwireless.net/"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "expat gmp imagemagick tiff fakeroot-native zlib bzip2"
PR = "r2"

SRC_URI = "http://www.kismetwireless.net/code/kismet-${PV}.tar.gz"

EXTRA_OECONF = "--enable-wsp100 --with-pcap=linux \
                --with-linuxheaders=${STAGING_KERNEL_DIR}/include"

inherit autotools

fakeroot do_install() {
     oe_runmake "DESTDIR=${D}" suidinstall
}

do_install_append() {
	if test -e ${WORKDIR}/kismet.conf; then
		install -m 644 ${WORKDIR}/kismet.conf ${D}${sysconfdir}/
	fi
}

PACKAGES =+ "${PN}-sounds ${PN}-gpsmap"

FILES_${PN}-sounds = "${datadir}/kismet/wav"
RDEPENDS_${PN}-sounds = "sox"

FILES_${PN}-gpsmap = "${bindir}/gpsmap*"
RDEPENDS_${PN}-gpsmap = "gpsd"

CONFFILES_${PN} = "${sysconfdir}/kismet.conf ${sysconfdir}/kismet_ui.conf ${sysconfdir}/kismet_drone.conf"

