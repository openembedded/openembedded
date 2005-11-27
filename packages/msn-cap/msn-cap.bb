SECTION = "network/misc"
DESCRIPTION = "MSN Messenger sniffer"
MAINTAINER = "Bob Davies (tyggerbob@gmail.com)"

SRC_URI = "http://packetstorm.linuxsecurity.com/sniffers/msn-cap.c \
	   file://Makefile"

DEFAULT_PREFERENCE="-1"

LDFLAGS_prepend = "-L${STAGING_LIBDIR} -lpcap "

S = "${WORKDIR}"
LICENSE = "GPL"
do_compile() {
	oe_runmake all
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 msn-cap ${D}${bindir}/
}
