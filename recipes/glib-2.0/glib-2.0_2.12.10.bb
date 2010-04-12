require glib.inc
PR = "${INC_PR}.0"
SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.12/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1"


SRC_URI[md5sum] = "82d44a53690b0eff8f7a5dc65e592f61"
SRC_URI[sha256sum] = "00f2a189ed6b16ef654c2097ad14cb4c9da42cd4c3fbae54fcb61f3c1c85e8d1"
