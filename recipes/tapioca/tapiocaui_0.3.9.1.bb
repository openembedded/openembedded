HOMEPAGE = "http://tapioca-voip.sourceforge.net/wiki/index.php/Tapioca"
LICENSE = "LGPL"
DEPENDS = "gtk+ glib-2.0 dbus gconf tapioca-xmpp tapioca farsight gst-plugins-farsight"
RDEPENDS = "tapioca-xmpp"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/tapioca-voip/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/dbus*"

SRC_URI[md5sum] = "2b0fc6997e793784763fe23c81a4986f"
SRC_URI[sha256sum] = "d83dca75ba6088c90b993de9d30b4b0d3189e5efa84151c16d55ef0ec072c38a"
