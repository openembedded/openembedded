DESCRIPTION = "OBEX Server and Client"
DEPENDS = "openobex glib-2.0 dbus bluez4"

LICENSE = "GPLv2"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/obexd-${PV}.tar.gz"

inherit autotools_stage

FILES_${PN} += "${datadir}/dbus-1/"

SRC_URI[md5sum] = "b9fbc1386b24f59b36aeb9d764c11fb5"
SRC_URI[sha256sum] = "8ed452371010117e183ade4e1e3ae4b489485b792722bf3b97b817cf0ed66ac8"
