include bluez-utils.inc

PR = "r11"

DEPENDS += "dbus"
SRC_URI += "file://dbus.patch;patch=1 \
	    file://smash.patch;patch=1 \
	    file://hciattach_devlength.patch;patch=1 \
	    file://hcid-alignment-fix.patch;patch=1"
EXTRA_OECONF += "--with-dbus"

