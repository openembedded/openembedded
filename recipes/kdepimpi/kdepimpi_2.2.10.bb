SRC_URI = "${SOURCEFORGE_MIRROR}/kdepimpi/kdepimpi-${PV}.tar.gz \
            file://qt-mt.patch;patch=1" 

require kdepimpi-base.inc

PR = "r0"

SRC_URI[md5sum] = "1b918fa70812b24df0c4de00bb2c8896"
SRC_URI[sha256sum] = "88f68d15052932ac763c007570a6e12e7be6e0d177706f96ddda7c358adcf871"
