DESCRIPTION = "Connection tracking userspace tools for Linux"
LICENSE = "GPL"
DEPENDS = "libnfnetlink libnetfilter-conntrack"

SRC_URI = " \
	http://www.netfilter.org/projects/conntrack-tools/files/conntrack-tools-${PV}.tar.bz2;name=tar \
	file://conntrack-failover \
	file://init \
	"
SRC_URI[tar.md5sum] = "7e9344fe85bb68bcf65c35034add6655"
SRC_URI[tar.sha256sum] = ""

inherit autotools
inherit update-rc.d

INITSCRIPT_NAME = "conntrackd"

do_install_append() {
	install -d ${D}/${sysconfdir}/conntrackd
	install -d ${D}/${sysconfdir}/init.d
	install -m 0644 doc/sync/ftfw/conntrackd.conf ${D}/${sysconfdir}/conntrackd/conntrackd.conf.sample
	install -m 0755 ${WORKDIR}/conntrack-failover ${D}/${sysconfdir}/init.d/conntrack-failover
	install -m 0755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/conntrackd
}