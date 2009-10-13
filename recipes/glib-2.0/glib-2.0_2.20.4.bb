require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "\
  http://ftp.gnome.org/pub/GNOME/sources/glib/2.20/glib-${PV}.tar.bz2 \
  file://glibconfig-sysdefs.h \
  file://configure-libtool.patch;patch=1 \
"
SRC_URI_append_arm = " file://atomic-thumb.patch;patch=1"
