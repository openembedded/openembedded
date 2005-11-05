DESCRIPTION = "Shorewall is a high-level tool for configuring Netfilter."
HOMEPAGE = "http://www.shorewall.net/"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPL"
SECTION = "network"
PRIORITY = "optional"
PR = "r3"

RDEPENDS = "iptables"
RRECOMMENDS = "kernel-module-ip-tables kernel-module-ip-conntrack kernel-module-ipt-conntrack kernel-module-ipt-multiport kernel-module-ipt-log kernel-module-ipt-mac kernel-module-ipt-mark kernel-module-ipt-masquerade kernel-module-ipt-pkttype kernel-module-ipt-reject kernel-module-ipt-state kernel-module-ipt-tos kernel-module-iptable-filter kernel-module-iptable-mangle kernel-module-iptable-nat"

SRC_URI = "http://www.shorewall.net/pub/shorewall/2.0/shorewall-2.0.9/shorewall-2.0.9.tgz \
	file://install-no-chown.diff;patch=1;pnum=0"
SRC_URI_append_nylon = " file://shorewall-conf-nylon.diff;patch=1"

do_install() {
	export PREFIX=${D}
	${S}/install.sh
}

CONFFILES_${PN}_nylon = "\
${sysconfdir}/shorewall/accounting \
${sysconfdir}/shorewall/actions \
${sysconfdir}/shorewall/blacklist \
${sysconfdir}/shorewall/ecn \
${sysconfdir}/shorewall/hosts \
${sysconfdir}/shorewall/init \
${sysconfdir}/shorewall/initdone \
${sysconfdir}/shorewall/interfaces \
${sysconfdir}/shorewall/maclist \
${sysconfdir}/shorewall/masq \
${sysconfdir}/shorewall/modules \
${sysconfdir}/shorewall/nat \
${sysconfdir}/shorewall/netmap \
${sysconfdir}/shorewall/params \
${sysconfdir}/shorewall/policy \
${sysconfdir}/shorewall/proxyarp \
${sysconfdir}/shorewall/routestopped \
${sysconfdir}/shorewall/rules \
${sysconfdir}/shorewall/shorewall.conf \
${sysconfdir}/shorewall/start \
${sysconfdir}/shorewall/stop \
${sysconfdir}/shorewall/stopped \
${sysconfdir}/shorewall/tcrules \
${sysconfdir}/shorewall/tos \
${sysconfdir}/shorewall/tunnels \
${sysconfdir}/shorewall/zones"
