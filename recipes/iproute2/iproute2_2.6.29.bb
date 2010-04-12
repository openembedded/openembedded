require iproute2.inc

PR = "${INC_PR}.1"

SRC_URI = "http://developer.osdl.org/dev/iproute2/download/${P}.tar.bz2 \
	   file://new-flex-fix.patch;patch=1 \
	   file://compilation-fix.patch;patch=1 \
	   file://use-cross-compiler.patch;patch=1 \
	   file://remove-bashisms.patch;patch=1 \
	  "

S = "${WORKDIR}/iproute2-${PV}"


SRC_URI[md5sum] = "a3ecfaa091289656fae786b027b44eda"
SRC_URI[sha256sum] = "ff7b78ebb112ebeb3901fe36823328c4af89040b890c25db43d8e35ccbc663b3"
