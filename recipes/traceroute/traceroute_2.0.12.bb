DESCRIPTION = "GNU traceroute"
HOMEPAGE = "http://traceroute.sourceforge.net"
SECTION = "network"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/traceroute/traceroute-${PV}.tar.gz;name=traceroute"

SRC_URI[traceroute.md5sum] = "2262a9d30ae85f12b759a38ef827f8f7"
SRC_URI[traceroute.sha256sum] = "d9609699982ac500cf361a34bd0685a1e5d71d001b6087e4eb68236048ff078f"

do_compile() {
	rm -rf ${S}/patches
	export LDFLAGS="${TARGET_LDFLAGS} -L${S}/libsupp"
	oe_runmake "env=yes"
}

do_install() {
	install -d ${D}${bindir}
	install -m 755 ${S}/traceroute/traceroute ${D}${bindir}
	mv ${D}${bindir}/traceroute ${D}${bindir}/traceroute.${PN}
}

pkg_postinst() {
	update-alternatives --install ${bindir}/traceroute traceroute ${bindir}/traceroute.${PN} 100
	update-alternatives --install ${bindir}/traceroute6 traceroute6 ${bindir}/traceroute.${PN} 100
}

pkg_postrm() {
	update-alternatives --remove traceroute ${bindir}/traceroute.${PN}
	update-alternatives --remove traceroute6 ${bindir}/traceroute.${PN}
}
