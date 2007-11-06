DESCRIPTION = "Kismet is an 802.11 layer2 wireless network detector, sniffer, and intrusion detection system"
HOMEPAGE = "http://www.kismetwireless.net/"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "expat gmp imagemagick tiff fakeroot-native zlib bzip2"
PV = "0.0+svnr${SRCREV}"
PR = "r2"
DEFAULT_PREFERENCE = "-1"
SRC_URI = "svn://svn.kismetwireless.net/code/branch/;module=kismet-newcore;proto=http"

EXTRA_OECONF = "--disable-gpsmap --enable-wsp100 --with-pcap=linux \
                --with-linuxheaders=${STAGING_KERNEL_DIR}/include"

inherit autotools

S = "${WORKDIR}/kismet-newcore"

fakeroot do_install() {
     oe_runmake "DESTDIR=${D}" suidinstall
}

PACKAGES =+ "${PN}-sounds"

FILES_${PN}-sounds = "${datadir}/kismet/wav"
RDEPENDS_${PN}-sounds = "sox"

CONFFILES_${PN} = "${sysconfdir}/kismet.conf ${sysconfdir}/kismet_ui.conf ${sysconfdir}/kismet_drone.conf"

