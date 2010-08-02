LICENSE = "LGPL"
DESCRIPTION = "Nokia OSSO IPC library"

DEPENDS = "dbus-glib glib-2.0 mce-dev"

inherit autotools pkgconfig lib_package

do_configure_prepend() {
  # Remove Werror from OSSO_CFLAGS since the source
  # contains many implicit (const void *) to (void *)
  # conversions.
  sed -i s:-Werror::g configure.ac
}

