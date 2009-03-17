DESCRIPTION = "Neuros videoplayer app"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r1"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "647d1fa634072f78894aecd090474389eaf6d6a4"
SRC_URI = "git://git.neurostechnology.com/git/app-vplayer;protocol=git"
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755  ${S}/build/vplayer ${D}/${bindir}
}


