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


SRC_URI[md5sum] = "90c6571b8b0309e372faa0f9f6255ea9"
SRC_URI[sha256sum] = "501b5acd4dff79b6100da22cef15080f31071821ce3cea6f1b739bc1b56fac3f"
