include dbus.inc

SRC_URI = "\
  http://dbus.freedesktop.org/releases/dbus/dbus-${PV}.tar.gz;name=dbus \
  file://tmpdir.patch;patch=1 \
  file://fix-install-daemon.patch;patch=1 \
  file://0001-Make-the-default-DBus-reply-timeout-configurable.patch;patch=1 \
  file://dbus-1.init \
"

SRC_URI[dbus.md5sum] = "565346cecd9cfecf1463540c6086cc2c"
SRC_URI[dbus.sha256sum] = "f12c748f4a703655e3d4c3db94cdf5a752a0cd0b36958c715804373bd3595c48"

