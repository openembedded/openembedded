DESCRIPTION = "Neuros window manager"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r2"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "d0b6789dde38d321d3c90c04512a4ea43e28e79e"
SRC_URI = "git://git.neurostechnology.com/git/app-nwm;protocol=git"
S = "${WORKDIR}/git/"

do_configure_prepend() {
	rm ${S}/src/Makefile || true
}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755  ${S}/build/nwm ${D}/${bindir}
}
