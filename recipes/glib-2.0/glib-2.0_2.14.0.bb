require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.14/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
           file://gcc-4.2-inline-fix.patch;patch=1"

SRC_URI[md5sum] = "6fabf21f68631043bc6924e01398e3af"
SRC_URI[sha256sum] = "92e0aed2b5816bfcdfcd943215a7b59e9000f89ae7824218b7959c90161560a8"
