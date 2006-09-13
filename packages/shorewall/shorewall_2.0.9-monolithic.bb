include shorewall_2.0.9.bb

RDEPENDS = "iptables kernel-module-ipt-multiport kernel-module-ipt-mac kernel-module-ipt-mark kernel-module-ipt-pkttype kernel-module-ipt-tos"

S = "${WORKDIR}/shorewall-2.0.9"
