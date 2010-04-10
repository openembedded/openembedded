require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.14/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
           file://gcc-4.2-inline-fix.patch;patch=1"

SRC_URI[md5sum] = "7ee7874108cbe9ea7fff1f4ab3389ce8"
SRC_URI[sha256sum] = "10e6ebecc2cbd07f193a5d26b88c3bf2107e32b2a4d024f10f77f59a98d579ff"
