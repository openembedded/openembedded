DESCRIPTION = "802.1q vlan support program"
RRECOMMENDS = "kernel-module-8021q"
MAINTAINER = "NSLU2 Linux <nslu2-linux@yahoogroups.com>"
PR = "r1"

S = "${WORKDIR}/vlan/"

SRC_URI = "http://scry.wanfear.com/~greear/vlan/vlan.1.8.tar.gz \
	   "

inherit base

do_install() {
	install -d "${D}/usr/sbin"
	install -m 755 "${S}/vconfig" "${D}/usr/sbin/vconfig"
}

