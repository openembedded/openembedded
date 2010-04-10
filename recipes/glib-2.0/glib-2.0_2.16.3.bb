require glib.inc
PR = "${INC_PR}.0"

# This version requires a newer libtool that isn't default yet 
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.16/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
          "

SRC_URI[md5sum] = "195f9a803cc5279dbb39afdf985f44cb"
SRC_URI[sha256sum] = "562742a234c7b842d891ec8ed4c9bead093c33863cca01e31912f59f6c8e887d"
