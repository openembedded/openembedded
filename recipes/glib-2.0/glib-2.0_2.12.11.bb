require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.12/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1"


SRC_URI[md5sum] = "077a9917b673a9a0bc63f351786dde24"
SRC_URI[sha256sum] = "706aa9da1c096af8d27b3ddb5da4e321dd6b10f881887639e280e4e10b81c4b3"
