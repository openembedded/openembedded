SECTION = "x11/wm"
DESCRIPTION = "Matchbox window manager"
LICENSE = "GPL"
DEPENDS = "libmatchbox x11 xext xcomposite libxfixes xdamage libxrender startup-notification expat gconf matchbox-common"
RDEPENDS = "matchbox-common"
PV = "0.9cvs${CVSDATE}"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=matchbox-window-manager;proto=http"

S = "${WORKDIR}/matchbox-window-manager"

inherit autotools  pkgconfig

FILES_${PN} = "${bindir} \
	       ${datadir}/matchbox \
	       ${datadir}/themes/blondie/matchbox \
	       ${datadir}/themes/bluebox/matchbox \
	       ${datadir}/themes/borillo/matchbox"

EXTRA_OECONF = "--enable-composite --enable-startup-notification --enable-expat"

pkg_postinst() {
update-alternatives --install /usr/bin/x-window-manager x-window-manager /usr/bin/matchbox-session 10
}

pkg_postrm() {
update-alternatives --remove x-window-manager /usr/bin/matchbox-session
}
