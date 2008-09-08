DESCRIPTION = "Neuros window manager"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r2"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "4dfc8ec91c284be45582bc51de8117610269d04d"
SRC_URI = "git://git.neurostechnology.com/git/app-mainmenu;protocol=git"
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755  ${S}/build/main-menu ${D}/${bindir}

	install -d ${D}/${sysconfdir}/menu
	install -m 0644 ${S}/resources/menu/* ${D}/${sysconfdir}/menu

	install -d ${D}/${sysconfdir}/nwm
	echo "${bindir}/mainmenu" > ${D}/${sysconfdir}/nwm/startup
}


