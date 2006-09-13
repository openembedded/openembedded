require bluez-utils.inc

PR = "r1"

SRC_URI += " file://hciattach-ti-bts.patch;patch=1"
EXTRA_OECONF += "--without-dbus"
