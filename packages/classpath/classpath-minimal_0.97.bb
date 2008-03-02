require classpath.inc

PR = "r0"

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
