require glib.inc
PR = "${INC_PR}.2"

SRC_URI = "\
  http://ftp.gnome.org/pub/GNOME/sources/glib/2.22/glib-${PV}.tar.bz2 \
  file://glibconfig-sysdefs.h \
  file://configure-libtool.patch;patch=1 \
  file://bug-556515.patch;patch=1 \
  file://g_once_init_enter.patch;patch=1 \
  file://uclibc-res_query.patch;patch=1 \
"


SRC_URI_append_arm = " file://atomic-thumb.patch;patch=1 \
"
SRC_URI_append_armv6 = " file://gatomic_armv6.patch;patch=1"
SRC_URI_append_armv7a = " file://gatomic_armv6.patch;patch=1" 
