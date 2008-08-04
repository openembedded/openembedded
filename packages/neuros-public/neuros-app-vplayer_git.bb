DESCRIPTION = "Neuros videoplayer app"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r0"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "8f8347f0baf46b9c4fa89afc743c726c651ed4a1"
SRC_URI = "git://git.neurostechnology.com/git/app-vplayer;protocol=git"
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755  ${S}/build/vplayer ${D}/${bindir}
}


