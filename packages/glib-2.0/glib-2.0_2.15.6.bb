require glib.inc

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.15/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
          "
