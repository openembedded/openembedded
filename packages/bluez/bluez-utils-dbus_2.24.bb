include bluez-utils.inc

PR = "r2"

DEPENDS += "dbus"
SRC_URI += "file://dbus-2.24.patch;patch=1"
EXTRA_OECONF += "--with-dbus"
