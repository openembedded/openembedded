require classpath.inc

SRC_URI += "\
  file://netif_16.patch;patch=1;pnum=0 \
  file://SimpleName.diff;patch=1;pnum=0 \
  "

PR = "r0"

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

