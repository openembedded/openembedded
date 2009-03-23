DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = "menu-cache"
RDEPENDS = "lxmenu-data"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

inherit autotools

FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"
EXTRA_OECONF += "--with-plugins=none"
