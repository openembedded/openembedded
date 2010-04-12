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


SRC_URI[md5sum] = "b84114df6ca8b20560524afed0e21b25"
SRC_URI[sha256sum] = "cc272f097832e074804bf405f2c013b4f941ad57f0f5f5ec6c08edecc9ad17fa"
