SECTION = "console/network"
DESCRIPTION = "A VPN solution via tun device.  Not IPSEC!"
HOMEPAGE = "http://openvpn.sourceforge.net"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPLv2"
PRIORITY = "optional"
DEPENDS = "lzo openssl"
RRECOMMENDS = "kernel-module-tun"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/openvpn/openvpn-2.0_rc1.tar.gz \
	file://openvpn"
S = "${WORKDIR}/openvpn-2.0_rc1"

inherit autotools

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/openvpn
	install -m 755 ${WORKDIR}/openvpn ${D}${sysconfdir}/init.d
}
