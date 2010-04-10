DESCRIPTION = "obex-data-server is a D-Bus service providing high-level OBEX client and server side functionality"
LICENSE = "GPLv2"

DEPENDS = "gtk+ bluez4 dbus-glib openobex"

SRC_URI = "http://tadas.dailyda.com/software/obex-data-server-${PV}.tar.gz"

inherit autotools

FILES_${PN} += "${datadir}/dbus-1/"


SRC_URI[md5sum] = "4aad0182812c770dde21246522be9f5e"
SRC_URI[sha256sum] = "aa567d986c74a4c8b4abb1cc454c099f67ab01b049b4c69aa6e703c7f18b594d"
