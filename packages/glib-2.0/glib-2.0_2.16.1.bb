require glib.inc

PR = "r5"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.16/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
           file://gcc-4.2-inline-fix.patch;patch=1 \
           file://hurd-arg-max.patch;patch=1 \
"
S = "${WORKDIR}/glib-${PV}"

