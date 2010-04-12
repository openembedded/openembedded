require classpath.inc

SRC_URI += "\
  file://gjar-prefix-patch.diff;patch=1;pnum=0 \
  file://xmlstream-fix.patch;patch=1;pnum=0 \
  file://javanet-local.patch;patch=1;pnum=0 \
  "

PR = "r7"

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



SRC_URI[md5sum] = "08638bb9221460cc311a1c5508083ed8"
SRC_URI[sha256sum] = "5c274a7741c35c35529f5641e644f61431143dac8e7724ac994d1f20c0d9cce0"
