require glib.inc
PR = "${INC_PR}.0"

# This version requires a newer libtool that isn't default yet 
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.16/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
          "

SRC_URI[md5sum] = "039f02d47d4071322a3f00abf031e5d9"
SRC_URI[sha256sum] = "cf14ee03a06c6adaa672ab18f6e5472a06c5d655379f9d8a5a6360b459c2eb20"
