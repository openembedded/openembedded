require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "\
  http://ftp.gnome.org/pub/GNOME/sources/glib/2.18/glib-${PV}.tar.bz2 \
  file://glibconfig-sysdefs.h \
  file://configure-libtool.patch;patch=1 \
"

SRC_URI[md5sum] = "06e5afe4ce055085dc5fd9fdab527bf7"
SRC_URI[sha256sum] = "624b9cfccc14781e699c9a3b2e332a51d63bba392c82d57b510d07a3f702362e"
