require iproute2.inc

PR = "${INC_PR}.2"

SRC_URI = "http://developer.osdl.org/dev/iproute2/download/${P}.tar.bz2 \
	   file://configure-cross.patch \
	  "

SRC_URI[md5sum] = "5c5742bdac05a1688f266512e685b83c"
SRC_URI[sha256sum] = "f7feb3c34df4714cae0265f7629863af8b0a88550f4f38aba0ffc81a10c29bbb"

S = "${WORKDIR}/iproute2-${PV}"

do_configure () {
    ./configure ${STAGING_DIR_TARGET}
}

do_install_append() {
	install -m 0755 tc/tc ${D}${base_sbindir}
}