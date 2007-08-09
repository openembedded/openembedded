DESCRIPTION = "gtk+ based dice roller for RPG games"
HOMEPAGE = "http://gdado.sf.net"
SECTION = "x11/games"
LICENSE = "GPLv2"
DEPENDS = "libgnomeui gtk+"
PR = "r1"
SRC_URI = "${SOURCEFORGE_MIRROR}/gdado/gdado-${PV}.tar.gz"

inherit autotools

do_install_prepend() {
	sed -i -e "s|Icon=gdado.png|Icon=${datadir}/pixmaps/gdado/gdado.png|" \
	gdado.desktop
}

