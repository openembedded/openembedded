include dbus.inc

PR = "${INC_PR}.0"

SRC_URI = "\
  http://dbus.freedesktop.org/releases/dbus/dbus-${PV}.tar.gz;name=dbus \
  file://tmpdir.patch \
  file://fix-install-daemon.patch \
  file://0001-Make-the-default-DBus-reply-timeout-configurable.patch \
  file://dbus-1.init \
"

SRC_URI[dbus.md5sum] = "54c5f3c79a1f852d2256aca07163813c"
SRC_URI[dbus.sha256sum] = "4cc258b4bc27f4af1233cf100e832c952fd4b7ce8ecb07d291d65ee137a38db7"

