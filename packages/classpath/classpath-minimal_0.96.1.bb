require classpath.inc

PR = "r7"

SRC_URI += "\
  file://gjar-prefix-patch.diff;patch=1;pnum=0 \
  file://xmlstream-fix.patch;patch=1;pnum=0 \
  "

PROVIDES = "${PN} classpath"

EXTRA_OECONF += "\
                --enable-local-sockets \
                --disable-alsa \
                --disable-gconf-peer \
                --disable-gtk-peer \
                --disable-plugin \
                --disable-dssi \
                --disable-examples \
               "

CPPACKAGES = "${PBN}-common ${PBN}-tools"
