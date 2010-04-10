SECTION = "console/network"
DESCRIPTION ="tinc is a Virtual Private Network (VPN) daemon"
HOMEPAGE = "http://www.tinc-vpn.org/"
LICENSE = "GPLv2"
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

SRC_URI[md5sum] = "5396e8d279b5140e86113c80abc041ad"
SRC_URI[sha256sum] = "2e6a535ba29d06337daf22ae12e17cbe10e70de95134ebd7b6e8a6838e3ca5a0"
