DESCRIPTION = "Hexatrolic a Ball Game"
SECTION = "opie/games"
PRIORITY    = "optional"
LICENSE     = "GPL"
AUTHOR      = "Helge Plehn"
HOMEPAGE    = "http://hexatrolic.i-networx.de/"
APPNAME     = "hexatrolic"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/hexatrolic-103beta3-zecke1.tar.bz2"

S = "${WORKDIR}/${APPNAME}"



do_install () {
	install -d ${D}${palmtopdir}/apps/Games/
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/pics/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/${APPNAME}.desktop ${D}${palmtopdir}/apps/Games
}


inherit opie

SRC_URI[md5sum] = "1d9420e8b5a6d5fa491c458ffafd4adb"
SRC_URI[sha256sum] = "b60a5358e56e676529e7d3d655d5107a76b9a2434e38952711fea794f65721ce"
