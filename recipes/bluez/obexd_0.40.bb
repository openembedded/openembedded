DESCRIPTION = "OBEX Server and Client"
DEPENDS = "openobex glib-2.0 dbus bluez4 libical"

LICENSE = "GPLv2"

PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/obexd-${PV}.tar.gz"

inherit autotools

FILES_${PN} += "${datadir}/dbus-1/"

SRC_URI[md5sum] = "243335d849700c30b318c360db95f62c"
SRC_URI[sha256sum] = "5440a3df1d33c2c12cca61fff1e8d643488ea139eef7340cfdbf6d2e5ea3e04b"
