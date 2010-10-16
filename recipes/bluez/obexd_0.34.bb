DESCRIPTION = "OBEX Server and Client"
DEPENDS = "openobex glib-2.0 dbus bluez4 libical"

LICENSE = "GPLv2"

PR = "r1"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/obexd-${PV}.tar.gz"
SRC_URI[md5sum] = "58dd77e7a005e9f1451c0c7efddbad92"
SRC_URI[sha256sum] = "7f8ed0ce47891d925275d7699527cd106cad14dd90094c8b2414286b2371e91c"

inherit autotools

FILES_${PN} += "${datadir}/dbus-1/"
