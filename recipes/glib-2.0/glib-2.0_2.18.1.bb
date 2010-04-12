require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "\
  http://ftp.gnome.org/pub/GNOME/sources/glib/2.18/glib-${PV}.tar.bz2 \
  file://glibconfig-sysdefs.h \
  file://configure-libtool.patch;patch=1 \
"
SRC_URI_append_arm = " file://atomic-thumb.patch;patch=1"

SRC_URI[md5sum] = "51a9a33f49a4896d4d95d8e980666b9e"
SRC_URI[sha256sum] = "57a47d4cd19757de0a7764488e6d4d8b0afa4849356a332b721a5219a991a0d0"
