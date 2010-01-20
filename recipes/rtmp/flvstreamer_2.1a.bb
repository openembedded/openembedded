DESCRIPTION = "flvstreamer is an open source command-line RTMP client intended to stream audio or video content from all types of flash or rtmp servers"
LICENSE = "GPLv2"

SRC_URI = "http://mirrors.igsobe.com/nongnu/flvstreamer/source/flvstreamer-${PV}.tar.gz"

S = "${WORKDIR}/${PN}"

do_compile() {
	sed -i -e /CFLAGS/d -e /LDFLAGS/d Makefile
	oe_runmake CROSS_COMPILE=${TARGET_PREFIX} CFLAGS="${CFLAGS}" LDFLAGS="${LDFLAGS} -lpthread" linux -e
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 flvstreamer rtmpsrv rtmpsuck streams ${D}${bindir}
}

