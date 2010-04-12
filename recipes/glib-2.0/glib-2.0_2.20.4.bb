require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "\
  http://ftp.gnome.org/pub/GNOME/sources/glib/2.20/glib-${PV}.tar.bz2 \
  file://glibconfig-sysdefs.h \
  file://configure-libtool.patch;patch=1 \
"
SRC_URI_append_arm = " file://atomic-thumb.patch;patch=1"

SRC_URI[md5sum] = "346916673c0eab72191cf44b4afe535f"
SRC_URI[sha256sum] = "af709f0eabfbbfa5c59a02764ca1dd5e6509bbe7fb67a474b2c448bda7b06fb9"
