SECTION = "console/network"
DESCRIPTION = "IPAC-NG is the iptables/ipchains based IP accounting package for Linux"
HOMEPAGE = "http://ipac-ng.sourceforge.net/"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
SRC_URI = "${SOURCEFORGE_MIRROR}/ipac-ng/ipac-ng-${PV}.tar.bz2 \
	file://makefile-build-cc.diff;patch=1;pnum=0"
RDEPENDS = "perl libgd-perl"
LICENSE = "GPL"

inherit autotools

do_configure() {
	oe_runconf
}

do_install_append() {
	install -d ${D}${sysconfdir}/ipac-ng
	install -m 644 ${S}/doc/ipac.conf.sample ${D}${sysconfdir}/ipac-ng
	install -m 644 ${S}/doc/rules.conf.sample ${D}${sysconfdir}/ipac-ng
}
