DESCRIPTION = "Hexatrolic a Ball Game"
SECTION     = "opie/games"
PRIORITY    = "optional"
MAINTAINER  = "none"
LICENSE     = "GPL"
AUTHOR      = "Helge Plehn"
HOMEPAGE    = "http://hexatrolic.i-networx.de/"
APPNAME     = "hexatrolic"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/hexatrolic-103beta3-zecke1.tar.bz2"

S = "${WORKDIR}/${APPNAME}"



do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/pics/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
}


inherit opie
