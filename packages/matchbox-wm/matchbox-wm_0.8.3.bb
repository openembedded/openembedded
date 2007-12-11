require matchbox-wm.inc

DEPENDS = "libmatchbox virtual/libx11 libxext libxcomposite libxfixes libxdamage libxrender startup-notification expat gconf "
RDEPENDS = ""

SRC_URI = "http://projects.o-hand.com/matchbox/sources/matchbox-window-manager/0.8/matchbox-window-manager-${PV}.tar.bz2 \
	file://kbdconfig_keylaunch_simpad.patch;patch=1;pnum=0"
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
