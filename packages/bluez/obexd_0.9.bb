DESCRIPTION = "OBEX Server and Client"
SECTION = "libs"
PRIORITY = "optional"

DEPENDS = "libusb1 dbus-glib bluez4 openobex"
HOMEPAGE = "http://www.bluez.org"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "\
  http://www.kernel.org/pub/linux/bluetooth/obexd-${PV}.tar.gz \
"    

#S = "${WORKDIR}/obexd-${PV}"

inherit autotools pkgconfig

