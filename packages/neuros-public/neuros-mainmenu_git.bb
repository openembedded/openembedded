DESCRIPTION = "Neuros window manager"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r0"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "27fc35bd349ccbac1226ebb3d41417d8164b7dd1"
SRC_URI = "git://git.neurostechnology.com/git/app-mainmenu;protocol=git"
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755  ${S}/build/main-menu ${D}/${bindir}

	install -d ${D}/${sysconfdir}/menu
	install -m 0644 ${S}/resources/menu/* ${D}/${sysconfdir}/menu
}


