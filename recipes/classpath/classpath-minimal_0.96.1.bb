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

SRC_URI[md5sum] = "a2ffb40f13fc76c2dda8f8311b30add9"
SRC_URI[sha256sum] = "ee464d20ef9df2196e238302d5d06954cb96a11e73c4c44c6ef376859de2a078"
