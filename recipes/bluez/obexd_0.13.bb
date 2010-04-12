DESCRIPTION = "OBEX Server and Client"
DEPENDS = "openobex glib-2.0 dbus bluez4"

LICENSE = "GPLv2"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/obexd-${PV}.tar.gz"

inherit autotools_stage

FILES_${PN} += "${datadir}/dbus-1/"

SRC_URI[md5sum] = "8764dcbcd7b5ed80e17b1279a82701b0"
SRC_URI[sha256sum] = "c986121e520897af6c326ece8a26eca87bdb4641a93913b63a5c29521cefaf66"
