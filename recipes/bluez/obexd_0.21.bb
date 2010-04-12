DESCRIPTION = "OBEX Server and Client"
DEPENDS = "openobex glib-2.0 dbus bluez4"

LICENSE = "GPLv2"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/obexd-${PV}.tar.gz"

inherit autotools_stage

FILES_${PN} += "${datadir}/dbus-1/"

SRC_URI[md5sum] = "3f2a7ae4ddca69001a23c034f8b28db6"
SRC_URI[sha256sum] = "d29e9694e09fc2a504b84e6929768a90ac76ced5492e755d50c55c350df5bf31"
