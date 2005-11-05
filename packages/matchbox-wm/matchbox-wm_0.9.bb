SECTION = "x11/wm"
DESCRIPTION = "Matchbox window manager"
LICENSE = "GPL"
DEPENDS = "libmatchbox x11 xext xcomposite libxfixes xdamage libxrender startup-notification expat gconf matchbox-common"
RDEPENDS = "matchbox-common"

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-window-manager/${PV}/matchbox-window-manager-${PV}.tar.gz"
S = "${WORKDIR}/matchbox-window-manager-${PV}"

inherit autotools  pkgconfig

FILES_${PN} = "${bindir} \
	       ${datadir}/matchbox \
	       ${datadir}/themes/blondie/matchbox \
	       ${datadir}/themes/bluebox/matchbox \
	       ${datadir}/themes/borillo/matchbox"

EXTRA_OECONF = "--enable-composite --enable-startup-notification --enable-expat"

pkg_postinst() {
update-alternatives --install ${bindir}/x-window-manager x-window-manager ${bindir}/matchbox-session 10
}

pkg_postrm() {
update-alternatives --remove x-window-manager ${bindir}/matchbox-session
}
