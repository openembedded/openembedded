DESCRIPTION = "DeviceKit is a simple system service that a) can enumerate devices; b) emits signals when devices are added removed; c) provides a way to merge device information / quirks onto devices."
LICENSE = "GPLv2"
DEPENDS = "udev dbus-glib glib-2.0"

PR = "r1"

SRC_URI = "http://hal.freedesktop.org/releases/DeviceKit-${PV}.tar.gz"
S = "${WORKDIR}/DeviceKit-${PV}"

do_configure_prepend() {
	sed -i -e s:-nonet:\:g ${S}/doc/man/Makefile.am
}	


FILES_${PN} += "${datadir}/dbus-1/"

SRC_URI[md5sum] = "8b311547f4a2c8c6b6598e3318d66cd7"
SRC_URI[sha256sum] = "d2d21f995d1a152ca2d8beea6d37f31e48cca034b82ceb7322f39422e849e9cf"
