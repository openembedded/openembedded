include dbus.inc

SRC_URI = "\
  http://dbus.freedesktop.org/releases/dbus/dbus-${PV}.tar.gz \
  file://tmpdir.patch;patch=1 \
  file://fix-install-daemon.patch;patch=1 \
  file://0001-Make-the-default-DBus-reply-timeout-configurable.patch;patch=1 \
  file://dbus-1.init \
"            

# This is the development version of dbus that will lead to 1.4.x
DEFAULT_PREFERENCE = "-1"

PR = "r0"
