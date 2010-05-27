include dbus.inc

SRC_URI = "\
  http://dbus.freedesktop.org/releases/dbus/dbus-${PV}.tar.gz \
  \
  file://will-1.patch \
  file://will-2.patch \
  file://will-3.patch \
  file://will-4.patch \
  file://will-5.patch \
  file://will-6.patch \
  \
  file://improve-threading-stability.patch \
  file://tmpdir.patch \
  file://fix-install-daemon.patch \
  file://0001-Make-the-default-DBus-reply-timeout-configurable.patch \
  file://dbus-1.init \
"            

# This is the development version of dbus that will lead to 1.4.x
DEFAULT_PREFERENCE = "-1"

PR = "r2"

SRC_URI[md5sum] = "b3298d5ce0e4ad4731b1e4e1787d56bb"
SRC_URI[sha256sum] = "fe32b49667894cf91b0a97503163be5c4814ecf67259e8feb26d1ba57cb03dae"
