include bluez-utils-common_${PV}.inc
DEPENDS += "dbus"
SRC_URI += "file://dbus.patch;patch=1 file://smash.patch;patch=1"
EXTRA_OECONF += "--with-dbus"

