include bluez-utils.inc

PR = "r2"

DEPENDS += "dbus"
SRC_URI += "file://smash.patch;patch=1 \
	    file://hcid-alignment-fix.patch;patch=1"
EXTRA_OECONF += "--with-dbus"
