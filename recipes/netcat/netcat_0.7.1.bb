DESCRIPTION = "GNU Netcat"
HOMEPAGE = "http://netcat.sourceforge.net"
SECTION = "console/network"
LICENSE = "GPLv2"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/netcat/netcat-${PV}.tar.bz2"

inherit autotools

do_install_append() {
	mv ${D}${bindir}/nc ${D}${bindir}/nc.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${bindir}/nc nc nc.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove nc nc.${PN}
}
