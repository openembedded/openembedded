require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.14/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
           file://gcc-4.2-inline-fix.patch;patch=1"

SRC_URI[md5sum] = "196d7944a8ddc1f7c3d1e9c7146dd560"
SRC_URI[sha256sum] = "6f36ca624a12dce03cdea59c9eb900eda49ea2f463b329737eb9f2a8f3ac144d"
