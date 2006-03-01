SECTION = "x11/wm"
DESCRIPTION = "Matchbox window manager"
LICENSE = "GPL"
DEPENDS = "libmatchbox libx11 libxext libxcomposite libxfixes libxdamage libxrender startup-notification expat gconf matchbox-common"
RDEPENDS = "matchbox-common"
PR = "r1" 


SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-window-manager/0.9/matchbox-window-manager-${PV}.tar.gz"

S = "${WORKDIR}/matchbox-window-manager-${PV}"

inherit autotools  pkgconfig

FILES_${PN} = "${bindir} \
	       ${datadir}/matchbox \
	       ${sysconfdir}/matchbox \
	       ${datadir}/themes/blondie/matchbox \
	       ${datadir}/themes/Default/matchbox \
	       ${datadir}/themes/MBOpus/matchbox"

EXTRA_OECONF = "--enable-composite --enable-startup-notification --disable-xrm"

pkg_postinst() {
update-alternatives --install ${bindir}/x-window-manager x-window-manager ${bindir}/matchbox-session 10
}

pkg_postrm() {
update-alternatives --remove x-window-manager ${bindir}/matchbox-session
}

