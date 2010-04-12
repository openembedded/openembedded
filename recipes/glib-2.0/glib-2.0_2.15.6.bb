require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.15/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1 \
          "

SRC_URI[md5sum] = "62b1a3c1fa52b8d91b4535e4a4ab3057"
SRC_URI[sha256sum] = "90e5e5d555479456f13f0ef8bb3518816994785fccb18fc2e65d432f8dd34272"
