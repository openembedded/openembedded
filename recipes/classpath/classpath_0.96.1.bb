require classpath.inc

SRC_URI += "\
  file://gjar-prefix-patch.diff;patch=1;pnum=0 \
  file://xmlstream-fix.patch;patch=1;pnum=0 \
  file://javanet-local.patch;patch=1;pnum=0 \
  "

PR = "r9"

DEPENDS += "gtk+ gconf libxtst"

EXTRA_OECONF += "\
                --disable-alsa \
                --disable-dssi \
                --disable-qt4-peer \
                --disable-plugin \
                --enable-gconf-peer \
                --enable-gtk-peer \
                --enable-local-sockets \
                --with-vm=java \
               "

SRC_URI[md5sum] = "a2ffb40f13fc76c2dda8f8311b30add9"
SRC_URI[sha256sum] = "ee464d20ef9df2196e238302d5d06954cb96a11e73c4c44c6ef376859de2a078"
