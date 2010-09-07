# NOTE: This is the last version configuring properly with clutter-1.0.x

require clutter-gtk.inc

PR = "${INC_PR}.0"

SRC_URI = "http://source.clutter-project.org/sources/clutter-gtk/0.10/clutter-gtk-${PV}.tar.bz2 \
           file://gtk-deprecated.patch \
          "

SRC_URI[md5sum] = "bb275b07f722631ff1764dd212843d11"
SRC_URI[sha256sum] = "de2af20d44d2237811f27ee081b9df999a0af30ee0d410cd7c2872622386b0c9"

