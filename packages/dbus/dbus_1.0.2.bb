require dbus.inc

DEFAULT_PREFERENCE = "1"

PR = "r8"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus/dbus-${PV}.tar.gz \
	   file://tmpdir.patch;patch=1 \
	   file://dbus-1.init \
	   file://cross.patch;patch=1 \
	   file://fix-install-daemon.patch;patch=1"



