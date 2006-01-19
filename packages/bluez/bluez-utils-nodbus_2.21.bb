include bluez-utils.inc

PR = "r3"

SRC_URI += "file://hciattach_devlength.patch;patch=1"
EXTRA_OECONF += "--without-dbus"
