require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/glib/2.12/glib-${PV}.tar.bz2 \
           file://glibconfig-sysdefs.h \
           file://configure-libtool.patch;patch=1"


SRC_URI[md5sum] = "0b3a42098243d054475ff6eb51ed2be1"
SRC_URI[sha256sum] = "debc507172093ef7c74e8a83bf49e090cc24057b1807d3be22e5d7cbfab60054"
