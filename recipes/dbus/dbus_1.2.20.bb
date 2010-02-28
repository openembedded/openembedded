include dbus.inc

SRC_URI = "\
  http://dbus.freedesktop.org/releases/dbus/dbus-${PV}.tar.gz;name=dbus \
  file://tmpdir.patch;patch=1 \
  file://fix-install-daemon.patch;patch=1 \
  file://0001-Make-the-default-DBus-reply-timeout-configurable.patch;patch=1 \
  file://dbus-1.init \
"

SRC_URI[dbus.md5sum] = "63f4e2412f6599a5e7b10281b9ddc0ac"
SRC_URI[dbus.sha256sum] = "0ef086d738710384d525130797ee86a0ce2daebffa7dc4d28386503ef7448011"

