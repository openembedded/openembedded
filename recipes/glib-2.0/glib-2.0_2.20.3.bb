require glib.inc
PR = "${INC_PR}.0"

SRC_URI = "\
  http://ftp.gnome.org/pub/GNOME/sources/glib/2.20/glib-${PV}.tar.bz2;name=tarball \
  file://glibconfig-sysdefs.h \
  file://configure-libtool.patch;patch=1 \
"
SRC_URI_append_arm = " file://atomic-thumb.patch;patch=1"

SRC_URI[tarball.md5sum] = "1173688c58b4b62809c83bb07a2cf71a"
SRC_URI[tarball.sha256sum] = "37f098617c2fac11eee4c6289d576300abd0a01825d4c809462f5b698d1127b0"
