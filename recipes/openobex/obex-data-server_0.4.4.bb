DESCRIPTION = "obex-data-server is a D-Bus service providing high-level OBEX client and server side functionality"
LICENSE = "GPLv2"

DEPENDS = "gtk+ bluez4 dbus-glib openobex"

SRC_URI = "http://tadas.dailyda.com/software/obex-data-server-${PV}.tar.gz"

inherit autotools

FILES_${PN} += "${datadir}/dbus-1/"

