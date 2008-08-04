DESCRIPTION = "Neuros photoalbum app"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r0"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "2e08d843f04a98738e66507f70fe3f503c263bff"
SRC_URI = "git://git.neurostechnology.com/git/app-photoalbum;protocol=git"
S = "${WORKDIR}/git/"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755  ${S}/build/photoalbum ${D}/${bindir}
}


