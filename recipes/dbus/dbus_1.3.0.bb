include dbus.inc

SRC_URI = "\
  http://dbus.freedesktop.org/releases/dbus/dbus-${PV}.tar.gz \
  \
  file://will-1.patch;patch=1 \
  file://will-2.patch;patch=1 \
  file://will-3.patch;patch=1 \
  file://will-4.patch;patch=1 \
  file://will-5.patch;patch=1 \
  file://will-6.patch;patch=1 \
  \
  file://improve-threading-stability.patch;patch=1 \
  file://tmpdir.patch;patch=1 \
  file://fix-install-daemon.patch;patch=1 \
  file://0001-Make-the-default-DBus-reply-timeout-configurable.patch;patch=1 \
  file://dbus-1.init \
"            

# This is the development version of dbus that will lead to 1.4.x
DEFAULT_PREFERENCE = "-1"

PR = "r2"

SRC_URI[md5sum] = "b3298d5ce0e4ad4731b1e4e1787d56bb"
SRC_URI[sha256sum] = "fe32b49667894cf91b0a97503163be5c4814ecf67259e8feb26d1ba57cb03dae"
