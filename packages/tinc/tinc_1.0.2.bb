SECTION = "console/network"
DESCRIPTION ="tinc is a Virtual Private Network (VPN) daemon"
HOMEPAGE = "http://www.tinc-vpn.org/"
LICENSE = "GPLv2"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
PR = "r1"

SRC_URI="http://www.tinc-vpn.org/packages/tinc-1.0.2.tar.gz \
	file://mtu-vlan.diff;patch=1 \
	file://public-key-fix.diff;patch=1 \
	file://init"

DEPENDS = "openssl lzo zlib"
RRECOMMENDS = "kernel-module-tun"

inherit autotools

EXTRA_OECONF = "--disable-maintainer-mode --disable-tracing"

do_configure() {
	oe_runconf
}

do_compile() {
	oe_runmake
}

do_install() {
        oe_runmake install DESTDIR=${D}
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/tinc
}
