DESCRIPTION = "OBEX Server and Client"
DEPENDS = "openobex glib-2.0 dbus bluez4"

LICENSE = "GPLv2"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/obexd-${PV}.tar.gz"

inherit autotools_stage

FILES_${PN} += "${datadir}/dbus-1/"

SRC_URI[md5sum] = "f9adc013e0e4b26c992cc0ca05328f3d"
SRC_URI[sha256sum] = "44ba0d99e1bf8fa2caf9f7a85d569e513208c0710c1ad00032e271289e87b63f"
