include bluez-utils.inc
DEPENDS += "dbus"
SRC_URI += "file://smash.patch;patch=1 \
	    file://hcid-alignment-fix.patch;patch=1"
EXTRA_OECONF += "--with-dbus"

