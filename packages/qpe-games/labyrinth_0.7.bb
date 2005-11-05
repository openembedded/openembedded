DESCRIPTION = "A traditional (german?) boardgame"
SECTION     = "opie/games"
PRIORITY    = "optional"
MAINTAINER  = "none"
LICENSE     = "GPL"
AUTHOR      = "Helge Plehn"
HOMEPAGE    = "http://hexatrolic.i-networx.de/"
APPNAME     = "labyrinth"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/labyrinth-0.7-zecke1.tar.gz"

S = "${WORKDIR}/${APPNAME}"

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -d ${D}${palmtopdir}/share/games/${APPNAME}/

	install -m 0644 ${S}/pics/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
	install -m 0644 ${S}/labyrinth.record ${D}${palmtopdir}/share/games/${APPNAME}/
}


inherit opie
