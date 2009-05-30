include dbus.inc

SRC_URI = "\
  http://dbus.freedesktop.org/releases/dbus/dbus-${PV}permissive.tar.gz \
  file://cross.patch;patch=1 \
  file://tmpdir.patch;patch=1 \
  file://fix-install-daemon.patch;patch=1 \
  file://0001-Make-the-default-DBus-reply-timeout-configurable.patch;patch=1 \
  file://dbus-1.init \
"
S = "${WORKDIR}/dbus-${PV}permissive"

PR = "r0"
