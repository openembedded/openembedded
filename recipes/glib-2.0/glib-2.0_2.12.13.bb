require glib.inc

PR = "${INC_PR}.0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.12/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1"


SRC_URI[md5sum] = "d76124236e4e216e8c0861341e967a76"
SRC_URI[sha256sum] = "1253d563ca2e50292d924849fe3a23c3b7bc707ab8b79bda19319f9d192b0e8e"
