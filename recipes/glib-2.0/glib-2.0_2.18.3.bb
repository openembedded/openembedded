require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "\
  http://ftp.gnome.org/pub/GNOME/sources/glib/2.18/glib-${PV}.tar.bz2 \
  file://glibconfig-sysdefs.h \
  file://configure-libtool.patch;patch=1 \
"
SRC_URI_append_arm = " file://atomic-thumb.patch;patch=1"

SRC_URI[md5sum] = "f13996a7bd57525d796a6593f26a7771"
SRC_URI[sha256sum] = "9f769e8449c8cc1d8789ba987e446bdac3ed22671d71f946c973c7aadccc0b36"
