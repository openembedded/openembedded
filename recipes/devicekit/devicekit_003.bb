DESCRIPTION = "DeviceKit is a simple system service that a) can enumerate devices; b) emits signals when devices are added removed; c) provides a way to merge device information / quirks onto devices."
LICENSE = "GPLv2"
DEPENDS = "udev dbus-glib glib-2.0"

SRC_URI = "http://hal.freedesktop.org/releases/DeviceKit-${PV}.tar.gz"
S = "${WORKDIR}/DeviceKit-${PV}"

inherit autotools_stage
AUTOTOOLS_STAGE_PKGCONFIG = "1"

FILES_${PN} += "${datadir}/dbus-1/"



