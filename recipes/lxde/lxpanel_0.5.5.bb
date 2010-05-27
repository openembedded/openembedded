DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = "menu-cache"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "6162b7e8d912a41f9c075fe982370bfb"
SRC_URI[sha256sum] = "729c3dc52e343fe15dfde40475875c2b3670b3b37958c6c1e4c936242cdc2e9b"

inherit autotools

RDEPENDS_${PN} = "lxmenu-data menu-cache"
FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"

