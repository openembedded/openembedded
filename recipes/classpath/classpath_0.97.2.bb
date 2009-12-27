require classpath.inc

SRC_URI += "\
  file://netif_16.patch;patch=1;pnum=0 \
  file://SimpleName.diff;patch=1;pnum=0 \
  file://javanet-local.patch;patch=1;pnum=0 \
  file://ecj_java_dir.patch;patch=1 \
  file://autotools.patch;patch=1 \
  file://decimalformat.patch;patch=1 \
  file://cp-byte-loophelper.patch;patch=1;pnum=0 \
  file://drawpolyline.patch;patch=1;pnum=0 \
  file://gtk-fix.patch;patch=1;pnum=0 \
  file://toolwrapper-exithook.patch;patch=1; \
  "

PR = "r10"

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

