DESCRIPTION = "User space daemon for extended IEEE 802.11 management"
HOMEPAGE = "http://hostap.epitest.fi"
SECTION = "kernel/userland"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "hostap-modules (${PV}) hostap-utils (${PV})"

SRC_URI = "http://hostap.epitest.fi/releases/hostapd-${PV}.tar.gz"
S = "${WORKDIR}/hostapd-${PV}"

do_install() {
	install -d ${D}${sysconfdir} ${D}${bindir}
	install -m 0644 hostapd.conf ${D}${sysconfdir}/
	install -m 0755 hostapd ${D}${bindir}
}

