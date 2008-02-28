require classpath.inc

PR = "r5"

SRC_URI += "file://gjar-prefix-patch.diff;patch=1;pnum=0"

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
