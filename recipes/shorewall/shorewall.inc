DESCRIPTION = "Shorewall is a high-level tool for configuring Netfilter."
HOMEPAGE = "http://www.shorewall.net/"
LICENSE = "GPLv2"
SECTION = "network"
PRIORITY = "optional"

INC_PR = "r0"

S = "${WORKDIR}/${PN}-${PV}"

RDEPENDS_${PN} += "iptables"
RRECOMMENDS_${PN} = "kernel-module-ip-tables kernel-module-ip-conntrack kernel-module-ipt-conntrack kernel-module-ipt-multiport kernel-module-ipt-log kernel-module-ipt-mac kernel-module-ipt-mark kernel-module-ipt-masquerade kernel-module-ipt-pkttype kernel-module-ipt-reject kernel-module-ipt-state kernel-module-ipt-tos kernel-module-iptable-filter kernel-module-iptable-mangle kernel-module-iptable-nat"

do_install() {
	export PREFIX=${D}
	${WORKDIR}/${PN}-${PV}/install.sh
}

FILES_${PN} += "/usr/share/shorewall/*"
