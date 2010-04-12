DESCRIPTION = "Telepathy framework - GLib library"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus libxslt-native python-native dbus-native"
LICENSE = "LGPL"

SRC_URI = "http://telepathy.freedesktop.org/releases/telepathy-glib/${P}.tar.gz "

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"


SRC_URI[md5sum] = "ae67d4fe42c7e337813754cb5927b6cc"
SRC_URI[sha256sum] = "7bf25e050e8b8ceb983c1cad6b4e38892b052f6da82df3b7aec7b2ea50a8702e"
