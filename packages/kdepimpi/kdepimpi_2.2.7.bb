SRC_URI = "${SOURCEFORGE_MIRROR}/kdepimpi/kdepimpi-${PV}.tar.gz \
           file://gcc4.patch;patch=1 \
	   file://qt-mt.patch;patch=1 \
	   file://gcc42.patch;patch=1"

require kdepimpi-base.inc

PR = "r2"
