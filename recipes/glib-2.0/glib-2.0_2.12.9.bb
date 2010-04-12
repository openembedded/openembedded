require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.12/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1"


SRC_URI[md5sum] = "b3f6a2a318610af6398b3445f1a2d6c6"
SRC_URI[sha256sum] = "10113e7b91f858557c7edb4b611cc009855c5ff8663af54977a65acb69445058"
