LICENSE = GPL
PR = "r1"
DESCRIPTION = "utility to allow middle and right clicking with a stylus"
SECTION = "x11/utils"
DEPENDS = "diet-x11 xext xpm"
SRC_URI = "http://www.handhelds.org/~mallum/downloadables/xmonobut/xmonobut-${PV}.tar.gz \
	   file://xmonobut.desktop"
inherit autotools

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0755 xmonobut ${D}${bindir}/xmonobut
	install -m 0644 xmonobut.xpm ${D}${datadir}/pixmaps/xmonobut.xpm
	install -m 0644 ${WORKDIR}/xmonobut.desktop ${D}${datadir}/applications/xmonobut.desktop
}
