DESCRIPTION = "Telepathy framework - GLib library"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus libxslt-native python-native dbus-native"
LICENSE = "LGPL"

SRC_URI = "http://telepathy.freedesktop.org/releases/telepathy-glib/${P}.tar.gz "

inherit autotools

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"


SRC_URI[md5sum] = "681b5b82fc3ec65d86a6cb409ec38e5d"
SRC_URI[sha256sum] = "7ae86c8f17cb00e827a0bb60b03345984b3065a33db3d119527d41993a09443d"
