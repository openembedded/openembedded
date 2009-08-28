require glib.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRC_URI = "\
  http://ftp.gnome.org/pub/GNOME/sources/glib/2.21/glib-${PV}.tar.bz2 \
  file://glibconfig-sysdefs.h \
  file://configure-libtool.patch;patch=1 \
"
SRC_URI_append_arm = " file://atomic-thumb.patch;patch=1 \
"
SRC_URI_append_armv6 = " file://gatomic_armv6.patch;patch=1"
SRC_URI_append_armv7a = " file://gatomic_armv6.patch;patch=1" 
