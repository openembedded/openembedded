DESCRIPTION = "Promiscuous mode IP Accounting package"
HOMEPAGE = "http://www.ba.cnr.it/~paolo/pmacct/"
LICENSE = "GPLv2"
DEPENDS = "libpcap"
PR = "r2"

SRC_URI = "http://www.ba.cnr.it/~paolo/pmacct/pmacct-${PV}.tar.gz \
	file://pmacct.init \
	file://pmacct.conf.eth0"

inherit autotools

# Without this it'll check for the headers in /usr/include
EXTRA_OECONF = "--with-pcap-includes=${STAGING_INCDIR}"

do_configure () {
	oe_runconf
}

do_install() {
	autotools_do_install
	install -d ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/pmacct
	install -m 755 ${WORKDIR}/pmacct.init ${D}${sysconfdir}/init.d/pmacct
	install -m 644 ${WORKDIR}/pmacct.conf.eth0 ${D}${sysconfdir}/pmacct
}

CONFFILES_nylon = "/etc/pmacct/pmacct.conf.eth0"
