DESCRIPTION = "Neuros photoalbum app"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r1"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "c306f8e1ab92d916d99516d6aebc0749c1be5f5e"
SRC_URI = "git://git.neurostechnology.com/git/app-photoalbum;protocol=git"
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755  ${S}/build/photoalbum ${D}/${bindir}
}


