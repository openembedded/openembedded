SECTION = "console/network"
DESCRIPTION = "A VPN solution via tun device.  Not IPSEC!"
PRIORITY = "optional"
DEPENDS = "lzo openssl"
RRECOMMENDS = "kernel-module-tun"
PR = "r2"
LICENSE = "GPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/openvpn/openvpn-${PV}.tar.gz \
	file://openvpn"

inherit autotools

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/openvpn
	install -m 755 ${WORKDIR}/openvpn ${D}${sysconfdir}/init.d
}
