include shorewall_2.0.9.bb

RDEPENDS = "iptables kernel-module-ipt-multiport kernel-module-ipt-mac kernel-module-ipt-mark kernel-module-ipt-pkttype kernel-module-ipt-tos"

S = "${WORKDIR}/shorewall-2.0.9"

SRC_URI[md5sum] = "4d0f756b5b63a68593b2de560c1a5b35"
SRC_URI[sha256sum] = "06064e929423b1bd60a31652d2a31763dccc48e86ea9cdefbcadf524df2bd3f2"
