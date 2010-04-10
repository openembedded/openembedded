DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = "menu-cache"
RDEPENDS = "lxmenu-data"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

inherit autotools

FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"
EXTRA_OECONF += "--with-plugins=none"

SRC_URI[md5sum] = "91f020d385ee29dcfff820d5c77a0e4f"
SRC_URI[sha256sum] = "0edf3fe88faf41c72c1da4522ba22ba2493d900061a79603858a6a3f6a74a735"
