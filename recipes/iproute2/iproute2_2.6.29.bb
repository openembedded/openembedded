require iproute2.inc

PR = "r1"

SRC_URI = "http://developer.osdl.org/dev/iproute2/download/${P}.tar.bz2 \
	   file://new-flex-fix.patch;patch=1 \
	   file://compilation-fix.patch;patch=1 \
	  "

S = "${WORKDIR}/iproute2-${PV}"

