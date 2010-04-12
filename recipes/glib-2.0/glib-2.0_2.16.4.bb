require glib.inc
PR = "${INC_PR}.0"

# This version requires a newer libtool that isn't default yet 
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.16/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
          "

SRC_URI_append_arm = "file://atomic-thumb.patch;patch=1"

SRC_URI[md5sum] = "2ab79b3c93258827cc6ea8ee50128e49"
SRC_URI[sha256sum] = "16ac93dc0da95cb20e4f14507fab688c4be1d23bcd2f28bc069c8ca7dc9d7e9d"
