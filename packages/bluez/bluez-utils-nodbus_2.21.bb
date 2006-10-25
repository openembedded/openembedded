require bluez-utils.inc

PR = "r4"

SRC_URI += "file://hciattach_devlength.patch;patch=1"
EXTRA_OECONF += "--without-dbus"
