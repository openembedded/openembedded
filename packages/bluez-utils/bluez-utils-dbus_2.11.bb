include bluez-utils-common_${PV}.inc
DEPENDS += "dbus"
SRC_URI += "file://dbus.patch;patch=1"
PR = "r3"
EXTRA_OECONF += "--with-dbus"

