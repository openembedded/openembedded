DESCRIPTION = "obex-data-server is D-Bus service providing high-level OBEX client and server side functionality"
HOMEPAGE = "http://wiki.muiline.com/obex-data-server"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "openobex bluez4 imagemagick dbus-glib"


SRC_URI = "http://tadas.dailyda.com/software/obex-data-server-${PV}.tar.gz"

inherit autotools
