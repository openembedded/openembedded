SRC_URI = "${SOURCEFORGE_MIRROR}/kdepimpi/kdepimpi-${PV}.tar.gz \
           file://gcc4.patch;patch=1"

include kdepimpi-base.inc

PR = "r1"
