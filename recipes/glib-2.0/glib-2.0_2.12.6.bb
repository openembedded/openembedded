require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.12/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1"


SRC_URI[md5sum] = "b13d971e7de0b844fc4ced7367702003"
SRC_URI[sha256sum] = "142d5d4795bef093eb9cfd50e384ae87ba9b9934d22b667174535d377ad47f1b"
