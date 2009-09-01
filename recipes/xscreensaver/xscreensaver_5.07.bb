require xscreensaver.inc
PR = "r3"

SRC_URI = "http://www.jwz.org/xscreensaver/xscreensaver-${PV}.tar.gz \
           file://configure.in.patch;patch=1 \
           file://glfix.patch;patch=1 \
           file://XScreenSaver"


