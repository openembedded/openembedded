require xscreensaver.inc
PR = "${INC_PR}.0"

SRC_URI = "http://www.jwz.org/xscreensaver/xscreensaver-${PV}.tar.gz \
           file://configure.in.patch;patch=1 \
           file://glfix.patch;patch=1 \
           file://dpms-header.patch;patch=1 \
           file://XScreenSaver"


