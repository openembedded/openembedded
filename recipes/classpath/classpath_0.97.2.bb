require classpath.inc

SRC_URI += "\
  file://netif_16.patch;apply=yes;striplevel=0 \
  file://SimpleName.diff;apply=yes;striplevel=0 \
  file://javanet-local.patch;apply=yes;striplevel=0 \
  file://ecj_java_dir.patch;apply=yes \
  file://autotools.patch;apply=yes \
  file://decimalformat.patch;apply=yes \
  file://cp-byte-loophelper.patch;apply=yes;striplevel=0 \
  file://drawpolyline.patch;apply=yes;striplevel=0 \
  file://gtk-fix.patch;apply=yes;striplevel=0 \
  file://toolwrapper-exithook.patch;apply=yes \
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


SRC_URI[md5sum] = "6a35347901ace03c31cc49751b338f31"
SRC_URI[sha256sum] = "001fee5ad3ddd043783d59593153510f09064b0d9b5aea82f535266f62f02db4"
