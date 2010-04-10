require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.16/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
           file://gcc-4.2-inline-fix.patch;patch=1 \
           file://hurd-arg-max.patch;patch=1 \
"
S = "${WORKDIR}/glib-${PV}"


SRC_URI[md5sum] = "9852daf0605f827bfd7199ffe4f5b22d"
SRC_URI[sha256sum] = "f305a828b53194a99c35dfb88efa4d83d3998a95b9d8843ca3f84c2959e56695"
