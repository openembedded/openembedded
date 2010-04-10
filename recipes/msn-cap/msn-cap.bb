SECTION = "network/misc"
DESCRIPTION = "MSN Messenger sniffer"

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

SRC_URI[md5sum] = "900be0beea498b18f03e2d67656d9d32"
SRC_URI[sha256sum] = "f03c69e064f1269dfd5adbc668204d0a7e0eafb86317e293e9d6c1ce0a4f5761"
