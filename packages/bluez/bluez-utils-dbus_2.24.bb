include bluez-utils.inc

PR = "r0"

DEPENDS += "dbus"
SRC_URI += "file://dbus.patch;patch=1"
EXTRA_OECONF += "--with-dbus"
