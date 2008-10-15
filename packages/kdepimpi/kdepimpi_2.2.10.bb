SRC_URI = "${SOURCEFORGE_MIRROR}/kdepimpi/kdepimpi-${PV}.tar.gz \
            file://qt-mt.patch;patch=1" 

require kdepimpi-base.inc

FILE_PR = "r0"
