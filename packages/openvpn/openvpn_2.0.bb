SECTION = "console/network"
DESCRIPTION = "A full-featured SSL VPN solution via tun device."
HOMEPAGE = "http://openvpn.sourceforge.net"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "lzo openssl"
RDEPENDS = "kernel-module-tun"
PR = "r1"

SRC_URI = "http://openvpn.net/release/openvpn-${PV}.tar.gz \
	file://openvpn"
S = "${WORKDIR}/openvpn-${PV}"

CFLAGS += "-fno-inline"

inherit autotools

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	install -d ${D}/${sysconfdir}/openvpn
	install -m 755 ${WORKDIR}/openvpn ${D}/${sysconfdir}/init.d
}
