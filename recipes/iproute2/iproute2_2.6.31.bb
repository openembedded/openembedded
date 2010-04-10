require iproute2.inc

PR = "${INC_PR}.0"

SRC_URI = "http://developer.osdl.org/dev/iproute2/download/${P}.tar.bz2 \
	   file://new-flex-fix.patch;patch=1 \
	  "

S = "${WORKDIR}/iproute2-${PV}"


SRC_URI[md5sum] = "230f35282a95451622f3e8394f9cd80a"
SRC_URI[sha256sum] = "56875eaed9c581645422d89e00fa7da512256c82ac3dae3c5051ff6827e83152"
