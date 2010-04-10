DESCRIPTION = "OBEX Server and Client"
DEPENDS = "openobex glib-2.0 dbus bluez4"

LICENSE = "GPLv2"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/obexd-${PV}.tar.gz"

inherit autotools_stage

FILES_${PN} += "${datadir}/dbus-1/"

SRC_URI[md5sum] = "2f03b81411a1f7c359ada35459d946a5"
SRC_URI[sha256sum] = "37fb4cffad7e361daffa9915ee6a37e615d0bf4d1f24760e585d5ac922515ca8"
