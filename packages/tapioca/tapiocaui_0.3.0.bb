MAINTAINER = "Koen Kooi <Koen@dominion.kabel.utwente.nl>"
HOMEPAGE = "http://tapioca-voip.sourceforge.net/wiki/index.php/Tapioca"
LICENSE = "LGPL"
DEPENDS = "gtk+ glib-2.0 dbus gconf tapioca-xmpp tapioca farsight gst-plugins-farsight"

inherit autotools pkgconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/tapioca-voip/${P}.tar.gz"

FILES_${PN} += "${datadir}/dbus*"
