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


SRC_URI[md5sum] = "7b1d1a3ab3cd0d93edd69e7b50ce6aca"
SRC_URI[sha256sum] = "5df6649dfcfd6c4d7259a99b6cb2f031491fc88ca9b2751632e4e78105f58df5"
