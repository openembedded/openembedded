DESCRIPTION = "Neuros window manager"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r4"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "e6c30ba6e5be217ca4bf7e98e00f87bb7241872c"
SRC_URI = "git://git.neurostechnology.com/git/app-nwm;protocol=git"
S = "${WORKDIR}/git/"

do_configure_prepend() {
	rm ${S}/src/Makefile || true
}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755  ${S}/build/nwm ${D}/${bindir}
	install -d ${D}/${libdir}
	ln -sf ${datadir}/fonts ${D}/${libdir}/fonts
}

FILES_${PN} += "${libdir}/fonts"
