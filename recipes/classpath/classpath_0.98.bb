require classpath.inc

SRC_URI += "\
  file://SimpleName.diff;patch=1;pnum=0 \
  file://ecj_java_dir.patch;patch=1 \
  file://autotools.patch;patch=1 \
  file://fix-gmp.patch;patch=1 \
  file://toolwrapper-exithook.patch;patch=1 \
  "

PR = "r3"

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

